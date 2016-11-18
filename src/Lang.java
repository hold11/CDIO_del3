/*
           ,                                             |
          /#\         _         _     _    ___   ___     | Projekt: Black Darkness 3 - CDIO_del2
         /###\       | |__   _ | | __| |  /_  | /_  |    | Version: v1.0.0
        /#####\      | '_ \ / \| |/ _  |    | |   | |    |
       /##,-,##\     | | | | O | | ( | |   _| |_ _| |_   | Anders Wiberg Olsen (s165241), Emil Johan Høg (s152282),
      /##(   )##\    |_| |_|\_/|_|\__,_|  |_____|_____|  | Iman Chelhi (s165228), Troels Just Christoffersen (s120052)
     /#.--   --.#\                                       | Sebastian Tibor Bakonyvári (s145918), Valentin Leon Christensen (s152735)
    /`           ´\                                      |
 */

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * This class handles localization of all strings in the game
 * @version 1.0.0
 */
public class Lang {
    private static String lang;
    private static String country;
    private static Locale locale;

    public static ResourceBundle resourceBundle;

    public static String msg(String message) { return resourceBundle.getString(message); }

    public static void setLanguage(String[] args) {
        if (args.length != 2) {
            lang    = "en";
            country = "US";
        } else {
            lang    = args[0];
            country = args[1];
        }

        locale = new Locale(lang, country);
        resourceBundle = ResourceBundle.getBundle("lang", locale);
    }
}
