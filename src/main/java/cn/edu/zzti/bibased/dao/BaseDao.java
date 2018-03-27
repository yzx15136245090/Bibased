package cn.edu.zzti.bibased.dao;

import cn.edu.zzti.bibased.dao.lagou.ActionLogDao;
import cn.edu.zzti.bibased.dao.mapper.CityMapper;
import cn.edu.zzti.bibased.dao.mapper.CompanyMapper;
import cn.edu.zzti.bibased.dao.mapper.PositionDetailMapper;
import cn.edu.zzti.bibased.dao.mapper.PositionsMapper;
import cn.edu.zzti.bibased.dto.City;
import cn.edu.zzti.bibased.dto.Company;
import cn.edu.zzti.bibased.dto.PositionDetail;
import cn.edu.zzti.bibased.dto.Positions;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by huaidou on  2018/3/27
 */
public class BaseDao {
    @Resource
    protected PositionsMapper positionsMapper;

    @Resource
    protected CityMapper cityMapper;

    @Resource
    protected CompanyMapper companyMapper;

    @Resource
    protected PositionDetailMapper positionDetailMapper;

    @Resource
    protected ActionLogDao actionLogDao;


    public void insertJob(Positions position){
        positionsMapper.insert(position);
    }
    public void batchInsertJobs(List<Positions> positionList){
        positionsMapper.batchInsert(positionList);
    }

    public void batchInsertCitys(List<City> cityList){
        cityMapper.batchInsert(cityList);
    }

    public void batchInsertCompanys(List<Company> companies){
        companyMapper.batchInsert(companies);
    }

    public List<Positions> queryLeafPositions(String include){
        return positionsMapper.queryLeafPositions(include);
    }

    public List<City> queryCitys(String include){
        return cityMapper.queryCity(include);
    }

    public void batchInsertPositionDetails(List<PositionDetail> positionDetails){
        positionDetailMapper.batchInsert(positionDetails);
    }
}
