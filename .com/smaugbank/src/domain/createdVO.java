package domain;

import java.time.LocalDateTime;

public class createdVO {
    
    private LocalDateTime createdTransfer;

    public createdVO(final LocalDateTime createdTransfer){
        this.createdTransfer = createdTransfer != null ? createdTransfer : LocalDateTime.now();
    }

    public LocalDateTime getValue() {
        return createdTransfer;
    }
    
}
