package mms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import mms.pojo.EasyUIResult;
import mms.pojo.Cloth;
import mms.services.ClothService;

@RequestMapping("Cloth")
@Controller
public class ClothController {
	// 服装controller
	@Autowired
	private ClothService clothService;

	// 通过clno查询服装信息
	@RequestMapping("QueryClothByClno")
	@ResponseBody
	public Cloth queryClothByClno(String clno) {
		Cloth cloth = clothService.queryClothByClno(clno);
		return cloth;
	}

	// 批量删除
	@RequestMapping(value = "DeleteRows", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deleteClothByRows(@RequestParam(value = "array[]") String[] array) {
		try {

			return clothService.deleteClothByRows(array);

		} catch (Exception e) {
			// TODO: handle exception
			return "操作异常，可能有其他用户正在操作" + "无法删该服装，请重新选择";
		}
	}

	// 保存服装信息
	@RequestMapping(value = "SaveCloth", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String saveCloth(Cloth cloth) {
		return clothService.saveCloth(cloth);
	}

	// 修改服装信息
	@RequestMapping(value = "ModifyCloth", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String modifyCloth(Cloth cloth) {
		return clothService.modifyCloth(cloth);
	}

	// easyui返回json
	@RequestMapping("GetMessage")
	@ResponseBody
	public EasyUIResult queryAllCloth(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "rows", defaultValue = "5") Integer rows) {
		return clothService.queryAllCloth(page, rows);

	}

	// 获得服装信息
	@RequestMapping("GetAllCloth")
	@ResponseBody
	public List<Cloth> getAllCloth() {
		List<Cloth> allCloth = clothService.getAllCloth();
		return allCloth;

	}
}
