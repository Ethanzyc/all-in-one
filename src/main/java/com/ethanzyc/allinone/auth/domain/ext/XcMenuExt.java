package com.ethanzyc.allinone.auth.domain.ext;

import com.ethanzyc.allinone.auth.domain.CategoryNode;
import com.ethanzyc.allinone.auth.domain.XcMenu;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Created by admin on 2018/3/20.
 */
@Data
@ToString
public class XcMenuExt extends XcMenu {

    List<CategoryNode> children;
}
