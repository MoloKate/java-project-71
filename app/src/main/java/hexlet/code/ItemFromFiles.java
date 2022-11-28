package hexlet.code;

public final class ItemFromFiles {
    public enum FILESTATE {added, deleted, changed, unchanged}
    private Object oldValue;
    private Object newValue;
    private FILESTATE status;
    public ItemFromFiles(Object inputOldValue, Object inputNewValue, FILESTATE inputStatus) {
        this.oldValue = inputOldValue;
        this.newValue = inputNewValue;
        this.status = inputStatus;
    }
    public ItemFromFiles(Object inputOdValue, FILESTATE inputStatus) {
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
    public FILESTATE getStatus() {
        return this.status;
    }
}
