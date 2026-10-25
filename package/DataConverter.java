package converter;

public class DataConverter {

    public static double convert(double value, String from, String to) {

        double bytes = 0;

        switch (from.toLowerCase()) {
            case "bytes" -> bytes = value;
            case "kb" -> bytes = value * 1024;
            case "mb" -> bytes = value * 1024 * 1024;
            case "gb" -> bytes = value * 1024 * 1024 * 1024;
            case "tb" -> bytes = value * 1024L * 1024 * 1024 * 1024;
        }

        switch(to.toLowerCase()) {
            case "bytes" -> {
                return bytes;
            }
            case "kb" -> {
                return bytes / 1024;
            }
            case "mb" -> {
                return bytes / (1024 * 1024);
            }
            case "gb" -> {
                return bytes / (1024 * 1024 * 1024);
            }
            case "tb" -> {
                return bytes / (1024L * 1024 * 1024 * 1024);
            }
        }

        return 0;
    }
}