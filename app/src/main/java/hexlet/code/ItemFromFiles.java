package hexlet.code;

public final class ItemFromFiles {
    public enum STATE {added, deleted, changed, unchanged}
    private Object oldValue;
    private Object newValue;
    private String status;
    public ItemFromFiles(Object inputOldValue, Object inputNewValue, String inputStatus) {
        this.oldValue = inputOldValue;
        this.newValue = inputNewValue;
        this.status = inputStatus;
    }
    public ItemFromFiles(Object inputOdValue, String inputStatus) {
        this.oldValue = inputOdValue;
        this.status = inputStatus;
        this.newValue = null;
    }
    public Object getNewValue() {
        return this.newValue;
    }
    public Object getOldValue() {
        return this.oldValue;
    }
    public String getStatus() {
        return this.status;
    }
}
