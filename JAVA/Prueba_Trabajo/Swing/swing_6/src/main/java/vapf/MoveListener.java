package vapf;

import java.util.EventListener;

public interface MoveListener extends EventListener {
    public void movementPerformed(MoveEvent e);
}
