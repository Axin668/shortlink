package com.axinstar.shortlink.admin.toolkit;

import com.alibaba.excel.EasyExcel;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 封装 EasyExcel 操作 Web 工具方法
 */
public class EasyExcelWebUtil {

    @SneakyThrows
    public static void write(HttpServletResponse response, String filename, Class<?> clazz, List<?> data) {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        filename = URLEncoder.encode(filename, StandardCharsets.UTF_8).replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + filename + ".xlsx");
        EasyExcel.write(response.getOutputStream(), clazz).sheet("Sheet").doWrite(data);
    }
}
