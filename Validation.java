package utils;

import java.util.Scanner;

public class Validation {

    public static Scanner sc = new Scanner(System.in);

    public static int inputChoice(String msg, int min, int max) {
        String str;
        int choice;
        do {
            try {
                System.out.print(msg);
                str = sc.nextLine().trim();
                if (str.isEmpty()) {
                    System.out.println("choice is not allowed to be empty, pls re-entry!");
                    continue;
                }
                choice = Integer.parseInt(str);
                if (choice < min || choice > max) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.err.println("choice must be an integer from " + min + " to " + max + ", pls re-entry !");
            }
        } while (true);
        return choice;
    }

    public static String intputSring(String msg, String err) {
        String name;
        String s = "";
        String str[];
        while (true) {
            try {
                System.out.print(msg);
                name = sc.nextLine().trim();
                if (!name.isEmpty()) {
                    str = name.split("\\s++");
                    for (String x : str) {
                        name = String.valueOf(x.charAt(0)).toUpperCase() + x.substring(1).toLowerCase();
                        s = s + " " + name;
                    }
                    break;
                }
                throw new Exception();
            } catch (Exception e) {
                System.err.println(err);
            }
        }
        return s;
    }

    public static double inputDouble(String msg, double min, double max) {
        String str;
        double choice;
        do {
            try {
                System.out.print(msg);
                str = sc.nextLine().trim();
                if (str.isEmpty()) {
                    System.out.println("choice is not allowed to be empty, pls re-entry!");
                    continue;
                }
                choice = Double.parseDouble(str);
                if (choice < min || choice > max) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.err.println("choice must be an integer from " + min + " to " + max + ", pls re-entry !");
            }

        } while (true);
        return choice;
    }

    public static int getInt(String mess, String errorNumberFormat, String errorOutOfRange, int min, int max) {
        while (true) {
            int ret = Integer.parseInt(getStringByRegex(mess, errorNumberFormat, "[0-9]+"));
            if (ret < min || ret > max) {
                System.err.println(errorOutOfRange);
            } else {
                return ret;
            }
        }
    }

    public static String getStringByRegex(String mess, String error, String regex) {

        String output = null;
        while (true) {
            System.out.print(mess);
            output = sc.nextLine();
            if (output.matches(regex)) {
                return output;
            } else {
                System.err.println(error);
            }
        }
    }

    public static boolean pressYNtoContinue(String mess) {
        //"Do you want to continue (Y/N): "
        String input = getStringByRegex(mess, "Y/N only!!!", "[YNyn]");
        return input.equalsIgnoreCase("y");
    }

    public static String inputYorN(String msg, String a, String b) {
        String choice;
        do {
            System.out.println(msg);
            choice = sc.nextLine().trim();
            if (choice.isEmpty()) {
                System.out.println("input is not allowed to be empty, pls re-entry !");
                continue;
            }
            if (!(choice.equalsIgnoreCase(a) || choice.equalsIgnoreCase(b))) {
                System.out.println("input must be " + a + "/" + b + ", pls re-entry !");
                continue;
            }
            break;
        } while (true);
        return choice;
    }

}
