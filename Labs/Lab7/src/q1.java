import java.util.*;

/**
 * Represents a programming projects
 */
class CodeProject{
    private String code = "";
    private String projectName;

    public CodeProject(String projectName) {
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
        return new Snapshot(code);
    }

    public void restore(Snapshot snapshot) {
        //implement restore
        this.code = snapshot.code;
    }

    //implement nested class Snapshot
    public static class Snapshot{
        private final String code;

        private Snapshot(String snapshotToSet){
            this.code = snapshotToSet;
        }
    }
}

/**
 * Represent a Version Control Service
 */

class Git
{
    // Choose a relevant data structure for the code Snapshots.
    private LinkedList<CodeProject.Snapshot> snapshots = new LinkedList<>();
    private CodeProject project;
    private int currentSnapshotIndex = -1;

    public Git(CodeProject project){
        this.project = project;
    }

    public void commit()
    {
        //implement commit
        snapshots.add(project.createSnapshot());
        currentSnapshotIndex ++;
    }

    public void rollback()
    {
        // implement rollback
        if(snapshots.isEmpty()) return;

        project.restore(snapshots.get(currentSnapshotIndex--));
    }

}

/**
 * Runs the main method using "Git"
 */
 class Hackathon {
    public static void main(String[] args) {
        CodeProject hackathonProject=new CodeProject("Hackathon");
        Git hackathonGit = new Git(hackathonProject);

        hackathonProject.addCode("Ok, Lets start");
        hackathonGit.commit();

        hackathonProject.addCode("pseudo code for the project \n" +
                "use Python 3.7 \n" +
                "create dictionary and get data \n");
        hackathonGit.commit();


        hackathonProject.addCode("add elements to dictionary: (Apple, 189), (Chips,547) \n" +
                "Calculate the best diet for me");
        hackathonGit.commit();


        System.out.println("State before rolled back");
        System.out.println(String.format("content: \n######## %s", hackathonProject.getCode()));
        System.out.println("\n"+"************************************************************" + "\n");

        hackathonGit.rollback();
        System.out.println("Rolled back once");
        System.out.println(String.format("content: \n######## %s", hackathonProject.getCode()));

        hackathonGit.rollback();
        System.out.println("Rolled back twice");
        System.out.println(String.format("content: \n######## %s", hackathonProject.getCode()));
    }
}