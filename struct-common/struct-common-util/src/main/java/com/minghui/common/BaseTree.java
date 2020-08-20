package com.minghui.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/***
 * @author ropeok.lk
 * @date
 */
@Data
public class BaseTree {

    /***
     * description:子节点Id
     */
    private Long childId;

    /***
     * description:父节点Id
     */
    private Long pId;

    /***
     * description:层级代码
     */
    private Integer type;

    /***
     * description:组织层级
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List childTree;

    /***
     * description:版本编号
     */
    private Integer recordVersion;
}
