package com.axinstar.shortlink.admin.controller;

import com.axinstar.shortlink.admin.common.convention.result.Result;
import com.axinstar.shortlink.admin.common.convention.result.Results;
import com.axinstar.shortlink.admin.dto.req.ShortLinkGroupSaveReqDTO;
import com.axinstar.shortlink.admin.dto.req.ShortLinkGroupSortReqDTO;
import com.axinstar.shortlink.admin.dto.req.ShortLinkGroupUpdateReqDTO;
import com.axinstar.shortlink.admin.dto.resp.ShortLinkGroupRespDTO;
import com.axinstar.shortlink.admin.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 短链接分组控制层
 */
@RestController
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    /**
     * 新增短链接分组
     */
    @PostMapping("/api/short-link/admin/v1/group")
    public Result<Void> save(@RequestBody ShortLinkGroupSaveReqDTO requestParam) {
        groupService.saveGroup(requestParam.getName());
        return Results.success();
    }

    /**
     * 查询短链接分组集合
     */
    @GetMapping("/api/short-link/admin/v1/group")
    public Result<List<ShortLinkGroupRespDTO>> listGroup() {
        List<ShortLinkGroupRespDTO> listGroup = groupService.listGroup();
        return Results.success(listGroup);
    }

    /**
     * 修改短链接分组名
     */
    @PutMapping("/api/short-link/admin/v1/group")
    public Result<Void> updateGroup(@RequestBody ShortLinkGroupUpdateReqDTO requestParam) {
        groupService.updateGroup(requestParam);
        return Results.success();
    }

    /**
     * 删除短链接分组名
     */
    @DeleteMapping("/api/short-link/admin/v1/group")
    public Result<Void> deleteGroup(@RequestParam String gid) {
        groupService.deleteGroup(gid);
        return Results.success();
    }

    /**
     * 短链接分组排序
     */
    @PostMapping("/api/short-link/admin/v1/group/sort")
    public Result<Void> sortGroup(@RequestBody List<ShortLinkGroupSortReqDTO> requestParam) {
        groupService.sortGroup(requestParam);
        return Results.success();
    }
}
