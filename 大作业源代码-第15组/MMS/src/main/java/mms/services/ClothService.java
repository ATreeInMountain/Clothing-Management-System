package mms.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import mms.mapper.ClothMapper;
import mms.pojo.EasyUIResult;
import mms.pojo.Cloth;

@Service
@Transactional
public class ClothService {

    @Autowired
    private ClothMapper clothMapper;

    public Cloth queryClothByClno(String clno) {
        return clothMapper.queryClothByClno(clno);
    }

    public EasyUIResult queryAllCloth(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<Cloth> cloths = clothMapper.queryAllCloth();
        PageInfo<Cloth> pageInfo = new PageInfo<Cloth>(cloths);
        return new EasyUIResult(pageInfo.getTotal(), cloths);
    }

    public String saveCloth(Cloth cloth) {
        if (queryClothByClno(String.valueOf(cloth.getClno())) != null) {
            return "服装编号已经存在，请重新输入编号";
        }
        clothMapper.saveCloth(cloth);
        return "保存成功";
    }

    public String deleteClothByClno(String clno) {
        try {
            clothMapper.deleteClothByClno(clno);
        } catch (Exception e) {
            return "删除失败，有其他人正在操作，无法删除此服装";
        }
        return "删除成功";
    }

    public String modifyCloth(Cloth cloth) {
        if (queryClothByClno(String.valueOf(cloth.getClno())) != null) {
            try {
                clothMapper.modifyCloth(cloth);
            } catch (Exception e) {
                return "修改失败，有其他人正在操作，无法修改编号";
            }
        }
        return "修改成功";
    }

    public List<Cloth> getAllCloth() {
        return clothMapper.queryAllCloth();
    }

    public String deleteClothByRows(String[] array) {
        try {
            for (String clno : array) {
                clothMapper.deleteClothByClno(clno);
            }
        } catch (Exception e) {
            throw new RuntimeException("删除失败", e);
        }
        return "删除成功";
    }

    public String queryMultiCloth(Cloth cloth, HttpSession session) {
        try {
            List<Cloth> cloths = clothMapper.queryMultiCloth(cloth);
            session.setAttribute("cloths", cloths);
            return "";
        } catch (Exception e) {
            return "操作异常，请刷新后操作";
        }
    }

    public EasyUIResult getMultiCloth(Integer page, Integer rows, HttpSession session) {
        PageHelper.startPage(page, rows);
        List<Cloth> cloths = (List<Cloth>) session.getAttribute("cloths");
        PageInfo<Cloth> pageInfo = new PageInfo<Cloth>(cloths);
        return new EasyUIResult(pageInfo.getTotal(), cloths);
    }
}
