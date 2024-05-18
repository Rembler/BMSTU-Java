import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Store {
    private int _itemIdSequence = 1;

    private final ExecutorService _storeExecutorService = Executors.newFixedThreadPool(3);
    private final HashMap<Integer, Item> _items = new HashMap<>();

    public void placeItem(long placingTimeMs) {
        var item = new Item(_itemIdSequence++, placingTimeMs);
        _items.put(item._id, item);

        _storeExecutorService.submit(item);
    }

    public void purchaseItem(int itemId) {
        var item = _items.get(itemId);

        item.purchase();
    }

    private class Item implements Callable<Object> {
        private final int _id;
        private final long _placingTimeMs;
        private Date _expectedPlacingEndDate = null;
        private boolean _isPlaced = false;
        private boolean _isPurchased = false;

        public Item(int id, long placingTimeMs) {
            _id = id;
            _placingTimeMs = placingTimeMs;
        }

        @Override
        public Object call() throws Exception {
            place();

            return null;
        }

        public void purchase() {
            if (!_isPlaced) {
                System.out.printf("Item %d is not placed yet. Remaining time (ms): %d\n", _id,  _expectedPlacingEndDate.getTime() - System.currentTimeMillis());

                return;
            }

            if (_isPurchased) {
                System.out.printf("Item %d is already purchased\n", _id);

                return;
            }

            _isPurchased = true;

            System.out.printf("Item %d is successfully purchased\n", _id);
        }

        private void place() throws Exception {
            System.out.printf("Item %d is being placed\n", _id);

            _expectedPlacingEndDate = new Date(System.currentTimeMillis() + _placingTimeMs);

            Thread.sleep(_placingTimeMs);

            _isPlaced = true;

            System.out.printf("Item %d is placed\n", _id);
        }
    }
}
