package domain;

import java.time.LocalDateTime;

public class Transfer {
    
    private LocalDateTime createdTransfer;

    public Transfer(final LocalDateTime createdTransfer){
        this.createdTransfer = createdTransfer != null ? createdTransfer : LocalDateTime.now();
    }

    public LocalDateTime getValue() {
        return createdTransfer;
    }

}
