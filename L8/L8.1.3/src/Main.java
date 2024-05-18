import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var store = new Store();
        Scanner sc = new Scanner(System.in);

        while (true) {
            var rawCommand = sc.nextLine();
            var command = parseCommand(rawCommand);

            if (command == null) {
                System.out.println("Invalid command");

                continue;
            }

            command.execute(store);
        }
    }

    private static ICommand parseCommand(String input) {
        var inputElements = input.split(" ");

        if (inputElements.length < 2) {
            return null;
        }

        return switch (inputElements[0]) {
            case "p" -> parsePlaceCommand(inputElements);
            case "b" -> parsePurchaseCommand(inputElements);
            default -> null;
        };
    }

    private static PlaceCommand parsePlaceCommand(String[] inputElements) {
        try {
            var placingTimeInSeconds = Integer.parseInt(inputElements[1]);

            return new PlaceCommand(placingTimeInSeconds * 1000L);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static PurchaseCommand parsePurchaseCommand(String[] inputElements) {
        try {
            var itemId = Integer.parseInt(inputElements[1]);

            return new PurchaseCommand(itemId);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public interface ICommand {
        void execute(Store store);
    }

    public static class PlaceCommand implements ICommand {
        private final long _placingTimeMs;

        public PlaceCommand(long placingTimeMs) {
            _placingTimeMs = placingTimeMs;
        }

        @Override
        public void execute(Store store) {
            store.placeItem(_placingTimeMs);
        }
    }

    public static class PurchaseCommand implements ICommand {
        private final int _itemId;

        public PurchaseCommand(int itemId) {
            _itemId = itemId;
        }

        @Override
        public void execute(Store store) {
            store.purchaseItem(_itemId);
        }
    }
}