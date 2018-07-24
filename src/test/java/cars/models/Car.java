package cars.models;

import java.util.ArrayList;
import java.util.List;

public class Car {
    public static List<Car> carList = new ArrayList<>();
    private String models;
    private String makes;
    private String years;
    private String engine;
    private String trans;

    public String getValues(String value) {
        switch (value) {
            case "makes": {
                return makes;
            }
            case "models": {
                return models;
            }
            case "years": {
                return years;
            }
            case "trans": {
                return trans;
            }
            case "engine": {
                return engine;
            }

        }
        return "";
    }

    public void setValue(String field, String value) {
        switch (field) {
            case "makes": {
                makes = value;
                break;
            }
            case "models": {
                models = value;
            }
            case "years": {
                years = value;
            }
            case "engine": {
                engine = value;
            }
            case "trans": {
                trans = value;
            }
        }
    }

    public void addCarToList() {
        carList.add(this);
    }
}

