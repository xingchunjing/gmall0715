package com.studio.jxc.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.studio.jxc.gmall.bean.*;
import com.studio.jxc.gmall.manage.mapper.*;
import com.studio.jxc.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;



import java.util.List;

@Service
public class ManageServiceImpl implements ManageService{
    @Autowired
    private BaseCatalog1Mapper baseCatalog1Mapper;
    @Autowired
    private BaseCatalog2Mapper baseCatalog2Mapper;
    @Autowired
    private BaseCatalog3Mapper baseCatalog3Mapper;
    @Autowired
    private BaseAttrInfoMapper baseAttrInfoMapper;
    @Autowired
    private BaseAttrValueMapper baseAttrValueMapper;
    @Override
    public List<BaseCatalog1> selectAllBaseCatalog1() {
        return baseCatalog1Mapper.selectAll();
    }

    @Override
    public List<BaseCatalog2> selectBaseCatalog2ByCatalog1Id(String catalog1Id) {
        BaseCatalog2 baseCatalog2 = new BaseCatalog2();
        baseCatalog2.setCatalog1Id(catalog1Id);
        return baseCatalog2Mapper.select(baseCatalog2);
    }

    @Override
    public List<BaseCatalog3> selectBaseCatalog3ByCatalog2Id(String catalog2Id) {
        BaseCatalog3 baseCatalog3 = new BaseCatalog3();
        baseCatalog3.setCatalog2Id(catalog2Id);
        return baseCatalog3Mapper.select(baseCatalog3);
    }

    @Override
    public List<BaseAttrInfo> selectBaseAttrInfoByCatalog3Id(String catalog3Id) {
        BaseAttrInfo baseAttrInfo = new BaseAttrInfo();
        baseAttrInfo.setCatalog3Id(catalog3Id);
        return baseAttrInfoMapper.select(baseAttrInfo);
    }

    @Override
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {
        //保存
         if(baseAttrInfo.getId()!=null&&baseAttrInfo.getId().length()>0){
             baseAttrInfoMapper.updateByPrimaryKeySelective(baseAttrInfo);
         }else{
             if(baseAttrInfo.getId().length()==0){
                 baseAttrInfo.setId(null);
             }
             baseAttrInfoMapper.insertSelective(baseAttrInfo);
        }
        //把原属性值全部清空
        BaseAttrValue baseAttrValueDel = new BaseAttrValue();
        baseAttrValueDel.setAttrId(baseAttrInfo.getId());
        baseAttrValueMapper.delete(baseAttrValueDel);

        if(baseAttrInfo.getAttrValueList()!=null&&baseAttrInfo.getAttrValueList().size()>0){
            for(BaseAttrValue baseAttrValue: baseAttrInfo.getAttrValueList()){
                //防止主键被赋上一个空字符串
                if(baseAttrValue.getId().length()==0){
                    baseAttrValue.setId(null);
                }
                baseAttrValue.setAttrId(baseAttrInfo.getId());
                baseAttrValueMapper.insertSelective(baseAttrValue);
            }
        }


    }
}
