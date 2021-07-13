package com.dm.nabidm.orm.domain.common;

import com.dm.nabidm.www.util.Validate;
import java.io.Serializable;
import java.util.Set;

public class UserDetailInfo  implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 5705584387976580848L;

    /** 사용자일련번호 */
    private Integer userId;

    /** 아이피 */
    private String remoteIP;

    /** 권한정보 목록 */
    private Set<String> authorities;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRemoteIP() {
        return remoteIP;
    }

    public void setRemoteIP(String remoteIP) {
        this.remoteIP = remoteIP;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    public boolean isAuthorities(String portalGroupCode){
        if(Validate.isNotNull(authorities)) {
            return authorities.contains(portalGroupCode);
        }
        return false;
    }

    @Override
    public String toString() {
        return "UserDetailInfo{" +
                "userId=" + userId +
                ", remoteIP='" + remoteIP + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}
