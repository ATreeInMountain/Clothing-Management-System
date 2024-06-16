package mms.mapper;

import java.util.List;

import mms.pojo.Cloth;

public interface ClothMapper {
    // 通过服装编号查询服装信息
    public Cloth queryClothByClno(String clno);

    // 查询所有服装信息
    public List<Cloth> queryAllCloth();

    // 保存服装信息
    public void saveCloth(Cloth cloth);

    // 通过服装编号删除服装信息
    public void deleteClothByClno(String clno);

    // 修改服装信息
    public void modifyCloth(Cloth cloth);

    // 多条件查询服装信息
    public List<Cloth> queryMultiCloth(Cloth cloth);
}
