import java.util.*;

/**
 * Represents a programming projects
 */
class CodeProject2{
    private String projectName;
    private String code = "";
    private int currentId = -1;

    public CodeProject2(String projectName) {
        this.projectName = projectName;
        System.out.println(String.format("Created a new project named: %s", this.projectName));
    }

    public void addCode(String newCode)
    {
        this.code += "\n" + newCode;
    }
    public String getCode() {
        return code;
    }

    public Snapshot createSnapshot() {
        //implement createSnapshot
        currentId++;
        return new Snapshot(currentId, code);
    }

    public int getCurrentId(){
        return currentId;
    }

    public void restore(Snapshot snapshot) {
        //implement restore
        code = snapshot.code;
        currentId = snapshot.id;
    }
    //implement nested class Snapshot
    public static class Snapshot {
        private String code;
        private int id;

        private Snapshot(int id, String codeToSave){
            this.id = id;
            this.code = codeToSave;
        }
    }
}


/**
 * Represent a Version Control Service
 */
class Git2
{
    // Choose a relevant data structure for the code Snapshots.
    TreeMap<Integer, CodeProject2.Snapshot> snapshots = new TreeMap<>();
    CodeProject2 project;

    public Git2(CodeProject2 project){
        this.project = project;
    }

    public int commit()
    {
        //implement commit
        CodeProject2.Snapshot snapshot = project.createSnapshot();
        int id = project.getCurrentId();
        snapshots.put(id, snapshot);
        return id;
    }

    public void rollback(int id)
    {
        // implement rollback by commit id
        if(snapshots.containsKey(id)){
            project.restore(snapshots.get(id));
        }
    }

}

class Hackathon2{
    public static void main(String[] args) {
        CodeProject2 hackathonProject=new CodeProject2("Hackathon");
        Git2 hackathonGit = new Git2(hackathonProject);

        hackathonProject.addCode("Ok, Lets start");
        int firstCommitId=hackathonGit.commit();

        hackathonProject.addCode("pseudo code for the project \n" +
                "use Python 3.7 \n" +
                "create dictionary and get data ");
        int secondCommitId=hackathonGit.commit();


        hackathonProject.addCode("add elements to dictionary: (Apple, 189), (Chips,547) \n" +
                "Calculate the best diet for me");
        int thirdCommitId=hackathonGit.commit();

        hackathonProject.addCode("just some more code");
        int forthCommitId=hackathonGit.commit();

        hackathonProject.addCode("and more code");
        int fifthCommitId=hackathonGit.commit();

        System.out.println("State before rolled back");
        System.out.println(String.format("content: \n######## %s", hackathonProject.getCode()));
        System.out.println("\n"+"************************************************************" + "\n");

        hackathonGit.rollback(thirdCommitId);
        System.out.println("Rolled back to commitId = "+thirdCommitId);
        System.out.println(String.format("content: \n######## %s", hackathonProject.getCode()));
        System.out.println("\n"+"************************************************************" + "\n");

        hackathonGit.rollback(firstCommitId);
        System.out.println("Rolled back to commitId = "+firstCommitId);
        System.out.println(String.format("content: \n######## %s", hackathonProject.getCode()));
    }

}