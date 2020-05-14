package com.outsourcing.combat.controller.testController;

import com.github.pagehelper.PageHelper;

import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.mapper.gameModelMapper;
import com.outsourcing.combat.pojo.gameModel;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import com.outsourcing.combat.utils.ToolUtil;
import com.outsourcing.combat.utils.uploadAndDownload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/gameModel")
public class gameModelController extends MsgUntil {

    @Autowired
    gameModelMapper gModelMapper;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/byAll")
    public JsonResult getAll(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        try {
            PageHelper.startPage(currentPage, pageSize);//分页
            List<gameModel> list = gModelMapper.getAll(currentPage, pageSize);
            PageInfo<gameModel> pageInfo = new PageInfo<gameModel>(list);
        /*Map<String, Object> data = new HashMap<String, Object>();//装载分页数据
        data.put("total_page", pageInfo.getTotal());//总条数
        data.put("total_size", pageInfo.getPages());//总页数
        data.put("current_page", currentPage);//当前页
        data.put("total_list", pageInfo.getList());//数据*/
            return pageInfo.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, pageInfo, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, MSG_Abnormal);
        }
    }

    @RequestMapping("/byId")
    public JsonResult getGameModelById(HttpServletRequest request, HttpServletResponse response) {
        try {
            String iid = ToolUtil.str("id", request);
            Integer id = Integer.parseInt(iid);
            if (ToolUtil.equalBool(id)) {
                gameModel model = gModelMapper.getGameModelById(id);
                if (model == null) {
                    return JsonResult.build(FLAG_FAILED, MSG_Output_AIR);
                }
                String modelUrl = model.getModelUrl();
                uploadAndDownload uad = null;
                uad.downloadFileAction(request, response, modelUrl);
                return JsonResult.build(FLAG_SUCCESS, model, MSG_Inquire_Success);
            } else {
                return JsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/byModelName")
    public JsonResult getGameModelByModelName(HttpServletRequest request, HttpServletResponse response) {
        try {
            String modelName = ToolUtil.str("modelName", request);
            if (ToolUtil.equalBool(modelName)) {
                gameModel gm = gModelMapper.getGameModelByModelName(modelName);
                if (gm == null) {
                    return JsonResult.build(FLAG_FAILED, MSG_Output_AIR);
                }
                String modelUrl = gm.getModelUrl();
                uploadAndDownload uad = null;
                uad.downloadFileAction(request, response, modelUrl);
                return JsonResult.build(FLAG_SUCCESS, gm, MSG_Inquire_Success);
            } else {
                return JsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/byModelSort")
    public JsonResult getGameModelByModelSort(HttpServletRequest request, HttpServletResponse response) {
        try {
            String sortData = ToolUtil.str("sortData", request);
            if (ToolUtil.equalBool(sortData)) {
                gameModel gm = gModelMapper.getGameModelBySort(sortData);
                if (gm == null) {
                    return JsonResult.build(FLAG_FAILED, MSG_Output_AIR);
                }
                String modelUrl = gm.getModelUrl();
                uploadAndDownload uad = null;
                uad.downloadFileAction(request, response, modelUrl);
                return JsonResult.build(FLAG_SUCCESS, gm, MSG_Inquire_Success);
            } else {
                return JsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/insertModel")
    public JsonResult insertGameModelByModel(@RequestParam("uploadFile") MultipartFile uploadFile, HttpServletRequest request) {
        try {
            String id = ToolUtil.str("id", request);
            String modelName = ToolUtil.str("modelName", request);
            String modelSort = ToolUtil.str("modelSort", request);
            String modelUrl = ToolUtil.str("modelUrl", request);
            String modelAddTime = ToolUtil.str("modelAddTime", request);
            String modelChangeTime = ToolUtil.str("modelChangeTime", request);
            if (ToolUtil.equalBool(id) && ToolUtil.equalBool(modelName) && ToolUtil.equalBool(modelSort) && ToolUtil.equalBool(modelUrl) && ToolUtil.equalBool(modelAddTime) && ToolUtil.equalBool(modelChangeTime)) {
                gameModel model = new gameModel(Integer.parseInt(id), modelName, modelSort, modelUrl, modelAddTime, modelChangeTime);
                Integer result = gModelMapper.insertGameModel(model);
                uploadAndDownload uad = null;
                boolean flag = uad.uploadFileAction(uploadFile, modelUrl);
                if (result == null && flag == false) {
                    return JsonResult.build(FLAG_FAILED, "插入失败,模型上传失败");
                } else {
                    return JsonResult.build(FLAG_SUCCESS, "插入成功");
                }
            } else {
                return JsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/regainById")
    public JsonResult insertRegainGameById(HttpServletRequest request) {
        try {
            String result = ToolUtil.str("id", request);
            if (ToolUtil.equalBool(result)) {
                Integer id = Integer.parseInt(result);
                Integer outcome = gModelMapper.insertRegainGameById(id);
                if (outcome == null) {
                    return JsonResult.build(FLAG_FAILED, MSG_Output_AIR);
                }
                return JsonResult.build(FLAG_SUCCESS, "已经将其放入回收站");
            } else {
                return JsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/regainByName")
    public JsonResult updateRegainByName(HttpServletRequest request) {
        try {
            String modelName = ToolUtil.str("modelName", request);
            if (ToolUtil.equalBool(modelName)) {
                Integer outcome = gModelMapper.updateRegainByName(modelName);
                if (outcome == null) {
                    return JsonResult.build(FLAG_FAILED, MSG_Enter_Air);
                }
                return JsonResult.build(FLAG_SUCCESS, MSG_Delete_Success);
            } else {
                return JsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/regainModelByDelete1")
    public JsonResult getRegainGameModelByDelete1() {
        try {
            List<gameModel> outcome = gModelMapper.getRegainGameModelByDelete1();
//        for (gameModel gm : outcome) {
//            System.out.println(gm.toString());
//        }
            if (outcome == null) {
                return JsonResult.build(FLAG_FAILED, MSG_Output_AIR);
            }
            return JsonResult.build(FLAG_SUCCESS, outcome);
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/deleteRegainByModelName")
    public JsonResult deleteRegainByModelName(@RequestParam("modelName") String modelName) {
        try {
            if (modelName == null) {
                return JsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            Integer outcome = gModelMapper.deleteRegainByModelName(modelName);
            if (outcome == null) {
                return JsonResult.build(FLAG_FAILED, MSG_Output_AIR);
            }
            return JsonResult.build(FLAG_SUCCESS, "删除成功");
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/deleteGameModelById")
    public JsonResult deleteGameModelById(Integer id) {
        try {
            if (id == null) {
                return JsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            Integer outcome = gModelMapper.deleteGameModelById(id);
            if (outcome == null || outcome == 0) {
                return JsonResult.build(FLAG_FAILED, MSG_Failure);
            }
            return JsonResult.build(FLAG_SUCCESS, MSG_Delete_Success);
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/updateGameModel")
    public JsonResult updateGameModel(@RequestParam("uploadFile") MultipartFile uploadFile, HttpServletRequest request, HttpServletResponse response) {
        try {
            String modelName = ToolUtil.str("modelName", request);
            String id = ToolUtil.str("id", request);
            String modelSort = ToolUtil.str("modelSort", request);
            String modelUrl = ToolUtil.str("modelUrl", request);
            String modelAddTime = ToolUtil.str("modelAddTime", request);
            String modelChangeTime = ToolUtil.str("modelChangeTime", request);
            if (ToolUtil.equalBool(id) && ToolUtil.equalBool(modelName) && ToolUtil.equalBool(modelSort) && ToolUtil.equalBool(modelUrl) && ToolUtil.equalBool(modelAddTime) && ToolUtil.equalBool(modelChangeTime)) {
                gameModel sample = new gameModel(Integer.parseInt(id), modelName, modelSort, modelUrl, modelAddTime, modelChangeTime);
                Integer outcome = gModelMapper.updateGameModel(sample);
                if (outcome == null || outcome == 0) {
                    return JsonResult.build(FLAG_FAILED, MSG_Output_AIR);
                }
                uploadAndDownload uad = null;
                boolean flag = uad.uploadFileAction(uploadFile, modelUrl);
                if (flag == true) {
                    return JsonResult.build(FLAG_SUCCESS, MSG_Modify_Success);
                } else {
                    return JsonResult.build(FLAG_FAILED, "模型更新失败");
                }
            } else {
                return JsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
