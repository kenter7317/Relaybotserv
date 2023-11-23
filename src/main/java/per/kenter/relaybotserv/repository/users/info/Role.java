package per.kenter.relaybotserv.repository.users.info;

import lombok.Getter;

@Getter
public enum Role {
    ROLE_ADMIN("관리자"), ROLE_MANAGER("매니저"), ROLE_MEMBER("일반사용자"), ROLE_LOCKED("잠긴 사용자");

    private final String description;

    Role(String description) {
        this.description = description;
    }
}
