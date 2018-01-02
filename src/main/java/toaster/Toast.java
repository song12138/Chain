package toaster;

/**
 * Created by paul on 2017/11/22.
 */
public class Toast {

    public enum Status {
        DRY,BUTTERED,JAMMED
    }

    private Status status = Status.DRY;

    private int id;

    public Toast(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public void butter(){
        this.status=Status.BUTTERED;
    }

    public void jam(){
        this.status = Status.JAMMED;
    }

    @Override
    public String toString() {
        return "toast" + id + status;
    }
}
