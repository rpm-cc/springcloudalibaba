package com.tencent.wework.api.domain.response.user;

import com.tencent.wework.api.domain.response.WeWorkResponse;
import lombok.Data;

import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/10/20 9:58
 * @version: 1.0
 * @description:
 */
@Data
public class DepartmentListResponse extends WeWorkResponse {

    List<Department> department;
}
