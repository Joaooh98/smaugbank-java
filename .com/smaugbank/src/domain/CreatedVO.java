package domain;

import java.time.LocalDateTime;

public class CreatedVO {
    
    private LocalDateTime createdTransfer;

    public CreatedVO(final LocalDateTime createdTransfer){
        this.createdTransfer = createdTransfer != null ? createdTransfer : LocalDateTime.now();
    }

    public LocalDateTime getValue() {
        return createdTransfer;
    }
    
}
