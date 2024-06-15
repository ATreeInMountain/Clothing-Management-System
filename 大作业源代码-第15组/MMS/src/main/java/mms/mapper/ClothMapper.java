package mms.mapper;

import java.util.List;

import mms.pojo.Cloth;

public interface ClothMapper {
	public Cloth queryClothByClno(String clno);

	public List<Cloth> queryAllCloth();

	public void saveCloth(Cloth cloth);

	public void deleteClothByClno(String clno);

	public void modifyCloth(Cloth cloth);

	public List<Cloth> queryMultiCloth(Cloth cloth);
}
