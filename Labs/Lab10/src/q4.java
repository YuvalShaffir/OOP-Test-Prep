//Given Code
class Valve{//do not edit this class
    private int currentFlow;

    public Valve() {
        currentFlow=0;
    }
    public void setFlow(int flow) {
        currentFlow=flow;
    }

    public int getFlow() {
        return currentFlow;
    }
}


interface Spout {//do not edit this class
    public int flow(int flow);
}

class BaseSpout implements Spout{//do not edit this class
    public int flow(int flow) {
        return flow;
    }
}


class Shower {//do not edit this class
    private Valve hotValve;
    private Valve coldValve;
    private Spout spout;
    // Other members of things like shower curtain, drain, etc.

    public Shower(Valve hotValve, Valve coldValve, Spout spout) {
        this.hotValve = hotValve;
        this.coldValve = coldValve;
        this.spout = spout;
    }

    public void setColdWater(int coldFlow) {
        coldValve.setFlow(coldFlow);
        int totalFlow=hotValve.getFlow()+coldFlow;
        System.out.println("Running flow "+spout.flow(totalFlow)+" with "+(coldFlow/totalFlow)*100+"% cold water");
    }

    public void setHotWater(int hotFlow) {
        hotValve.setFlow(hotFlow);
        int totalFlow=hotValve.getFlow()+hotFlow;
        System.out.println("Running flow "+spout.flow(totalFlow)+" with "+(hotFlow/totalFlow)*100+"% hot water");
    }
}


interface Faucet {//do not edit this class
    static int MAX_PERCENT_FLOW = 100;
    void open(int flow, int hotPercent);
}

//Write your answer to parts A,B,C under this comment!

// הוסיפו לקוד מחלקה בשם MixerFaucet עבור ברז מודרני שתממש את הממשק Faucet. 
// הברז מורכב משני שסתומים (Valve), חם, וקר, וזרבובית (Spout).
class MixerFaucet implements Faucet{
    private final Valve hotValve;
    private final Valve coldValve;
    private final Spout spout;

    //   בנאי, אשר מקבל שני שסתומים (חם וקר) וזרבובית, ומאתחל ברז סגור (שלא זורמים בו מים).
    public MixerFaucet(Valve hotValve, Valve coldValve, Spout spout){
        this.hotValve = hotValve;
        this.coldValve = coldValve;
        this.spout = spout;
    }

    // void open(int flow, int hotPercent)
    // השיטה פותחת את הברז עם עוצמת זרימה flow, ואחוז מים חמים hotPercent:
    // השיטה צריכה לפתוח את שסתום המים החמים עם עוצמת זרימה המחושבת ע"י עוצמת הזרימה הכוללת (flow) כפול אחוז המים החמים (hotPercent). 
    // בהתאם, יש לפתוח את שסתום המים הקרים עם עוצמת זרימה המחושבת ע"י עוצמת הזרימה הכוללת (flow) כפול אחוז המים הקרים שהוא המשלים ל-100% של hotPercent. למשל, אם עוצמת הזרימה 50, ואחוז המים החמים הוא 20%, השסתום החם יפתח עם זרימה 10, והשסתום הקר יפתח עם זרימה 40 (שזה 80% מתוך 50).
    // על השיטה להזרים דרך הזרבובית את עוצמת הזרימה הכוללת flow.
    // על השיטה להדפיס למסך הודעה על כך שהברז נפתח עם אחוז מים חמים hotPercent, ושבזרבובית שלו זורמת עוצמת הזרם המוחזרת על ידי הפונקציה ()flow שלה (בדומה להדפסה בשיטה ()Shower.setHotWater

    public void open(int flow, int hotPercent){
        hotValve.setFlow((int)(spout.flow(flow) *(float)hotPercent / MAX_PERCENT_FLOW));
        System.out.println(hotValve.getFlow());
        coldValve.setFlow((int) (spout.flow(flow) * (1- ((float)hotPercent / MAX_PERCENT_FLOW))));
        System.out.println((1- ((float)hotPercent / MAX_PERCENT_FLOW)));

        int totalFlow = spout.flow(flow);
        System.out.println("Running flow "+totalFlow+" with "+(double)hotValve.getFlow()/totalFlow*MAX_PERCENT_FLOW+"% " +
                "hot water");
    }
}

// כתבו מחלקה בשם  RenovatedShower עבור המקלחת המשופצת אשר מחליפה את המחלקה Shower. 

// במחלקה זו במקום 2 שסתומים וזרבובית, יהיה רק ברז אחד (Faucet). 
// שימו לב שאין צורך להרחיב או לשנות את המחלקה Shower. המחלקה RenovatedShower היא מחלקה חדשה שמחליפה אותה.

class RenovatedShower{
    private final Faucet faucet;
    // בנאי, אשר מקבל אובייקט מסוג Faucet.
    public RenovatedShower(Faucet faucet){
        this.faucet = faucet;
    }

    // השיטה פותחת את הברז בעוצמה ואחוז המים החמים הנתונים.
    void openWater(int flow, int hotPercent){
        faucet.open(flow, hotPercent);
    }
}

interface SpoutDecorator extends Spout{}

class Hose implements SpoutDecorator {
    private final Spout spout;

    public Hose(Spout spout){
        this.spout = spout;
    }

    public int flow(int flow) {
        if(flow < 10) flow = 0;
        else flow = flow - 10;

        return spout.flow(flow);
    }
}

class AeratorFilter implements SpoutDecorator {
    private final Spout spout;

    public AeratorFilter(Spout spout){
        this.spout = spout;
    }

    public int flow(int flow) {
        return spout.flow(flow / 2);
    }
}

class ShowerFactory{
    private Valve hotValve;
    private Valve coldValve;

    public ShowerFactory(Valve hotValve, Valve coldValve){
        this.hotValve = hotValve;
        this.coldValve = coldValve;
    }

    public RenovatedShower select(int input, Spout spout){
        switch(input) {
            case 1:
                return new RenovatedShower(new MixerFaucet(hotValve, coldValve, spout));
            case 2:
                return new RenovatedShower(new MixerFaucet(hotValve, coldValve, spout));
            case 3:
                return new RenovatedShower(new MixerFaucet(hotValve, coldValve, spout));
            default:
                return null;
        }

    }
}

class q4{
    public static void main(String[] args) {
        //Write your answer to part D under this comment
        BaseSpout baseSpout = new BaseSpout();
        Spout hoseSpout = new Hose(baseSpout);
        Spout smartHoseSpout = new AeratorFilter(hoseSpout);
        Spout HoseSmartSpout = new Hose(new AeratorFilter(baseSpout));

        ShowerFactory factory = new ShowerFactory(new Valve(), new Valve());

        RenovatedShower shower1 = factory.select(1, hoseSpout);
        shower1.openWater(80, 50);

        RenovatedShower shower2 = factory.select(2, smartHoseSpout);
        shower2.openWater(30, 70);

        RenovatedShower shower3 = factory.select(3, HoseSmartSpout);
        shower3.openWater(30, 90);
    }
}

/**
 * Write your answer to part E INSIDE OF this comment
 * I used the decorator design pattern for the hoses.
 * And I used the factory design pattern for selecting a renovated shower, this
 * way adding more showers will be much easier.
 *
 *
 *
 */