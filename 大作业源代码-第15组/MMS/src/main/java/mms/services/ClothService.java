package mms.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import mms.mapper.ClothMapper;
import mms.pojo.Agency;
import mms.pojo.EasyUIResult;
import mms.pojo.Cloth;

@Service
@Transactional
public class ClothService {
	@Autowired
	private ClothMapper clothMapper;

	public Cloth queryClothByClno(String clno) {
		// TODO Auto-generated method stub
		Cloth cloth = clothMapper.queryClothByClno(clno);
		return cloth;
	}

	public EasyUIResult queryAllCloth(Integer page, Integer rows) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, rows);
		List<Cloth> cloths = clothMapper.queryAllCloth();
		PageInfo<Cloth> pageInfo = new PageInfo<Cloth>(cloths);
		return new EasyUIResult(pageInfo.getTotal(), cloths);
	}

	public String saveCloth(Cloth cloth) {
		// TODO Auto-generated method stub
		if (queryClothByClno(cloth.getClno()+"") != null) {
			return "服装编号已经存在，请重新输入编号";
		}
		clothMapper.saveCloth(cloth);
		return "保存成功";
	}

	public String deleteClothByClno(String clno) {
		// TODO Auto-generated method stub
		try {
			clothMapper.deleteClothByClno(clno);
		} catch (Exception e) {
			// TODO: handle exception
			return "删除失败，有其他人正在操作，" + "无法删除此服装";
		}
		return "删除成功";
	}

	public String modifyCloth(Cloth cloth) {
		// TODO Auto-generated method stub
		Cloth queryClothByClno = queryClothByClno(cloth.getClno()+"");
		if (queryClothByClno != null) {
			try {
				clothMapper.modifyCloth(cloth);
			} catch (Exception e) {
				// TODO: handle exception
				return "修改失败，有其他人正在操作，" + "无法修改编号";
			}
		}
		return "修改成功";
	}

	public List<Cloth> getAllCloth() {
		// TODO Auto-generated method stub
		List<Cloth> queryAllCloth = clothMapper.queryAllCloth();
		return queryAllCloth;
	}

	public String deleteClothByRows(String[] array) {
		// TODO Auto-generated method stub
		try {
			for (String clno : array) {
				clothMapper.deleteClothByClno(clno);
			}
		} catch (Exception e) {
			// TODO: handle exception
			// 抛出异常让spring捕获，进行事务回滚
			throw new RuntimeException();

		}
		return "删除成功";
	}

	public String queryMultiCloth(Cloth cloth, HttpSession session) {
		// TODO Auto-generated method stub
		try {
			List<Cloth> cloths = clothMapper.queryMultiCloth(cloth);
			session.setAttribute("cloths", cloths);
			System.out.println(cloths);
			System.out.println("@@@@@");
			return "";
		} catch (Exception e) {
			// TODO: handle exception
			return "操作异常，请刷新后操作";
		}
	}

	public EasyUIResult getMultiCloth(Integer page, Integer rows, HttpSession session) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, rows);
		List<Cloth> cloths = (List<Cloth>) session.getAttribute("cloths");
		System.out.println(cloths);
		PageInfo<Cloth> pageInfo = new PageInfo<Cloth>(cloths);
		return new EasyUIResult(pageInfo.getTotal(), cloths);
	}
}
