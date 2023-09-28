package domain;

import java.time.LocalDateTime;

public class TransferVO {
    
    private LocalDateTime createdTransfer;

    public TransferVO(final LocalDateTime createdTransfer){
        this.createdTransfer = createdTransfer != null ? createdTransfer : LocalDateTime.now();
    }

    public LocalDateTime getValue() {
        return createdTransfer;
    }
    
}
