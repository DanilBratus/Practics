package org.springframework.context.event;

public class ContextClosedEvent {
    public void startContextClosed() {
        System.out.println("**Выполнение Listener**");
    }
}
