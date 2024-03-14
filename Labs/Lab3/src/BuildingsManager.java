import java.text.DecimalFormat;

interface Building {
    double getVolume();
    String getName();
}

class AzrieliTriangle implements Building {
    private double width, height;

    public AzrieliTriangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return 0.5 * Math.pow(width, 2) * height;
    }

    @Override
    public String getName() {
        return "Azrieli Triangle";
    }
}


class CinemaCity implements Building {
    private double radius, height;

    public CinemaCity(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return Math.pow(radius, 2) * Math.PI * height;
    }

    @Override
    public String getName() {
        return "Cinema City";
    }
}

class CSEBuildingA implements Building {
    private double area, height;

    public CSEBuildingA(double area, double height) {
        this.area = area;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return area * height;
    }

    @Override
    public String getName() {
        return "CSEBuilding A";
    }
}

class BuildingsManager {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        Building building;
        switch (args[0]) {
            case "Azrieli":
                building = new AzrieliTriangle(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
                break;
            case "CinemaCity":
                building = new CinemaCity(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
                break;
            case "CSE":
                building = new CSEBuildingA(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
                break;
            default:
                return;
        }
        System.out.printf("The volume of %s is %s m^3 \n", building.getName(),
                df.format(building.getVolume()) );
    }
}