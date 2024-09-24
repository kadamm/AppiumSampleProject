package exception;

public class PlatformNotSupportedException extends IllegalStateException {
    public PlatformNotSupportedException(String reason) {
        super(reason);
    }
}
