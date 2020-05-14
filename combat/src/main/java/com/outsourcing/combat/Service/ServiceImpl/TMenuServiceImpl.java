package com.outsourcing.combat.Service.ServiceImpl;

import com.outsourcing.combat.Service.TMenuService;
import com.outsourcing.combat.mapper.TMenuMapper;
import com.outsourcing.combat.pojo.TMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TMenuServiceImpl implements TMenuService {

    @Autowired
    TMenuMapper tMenuMapper;

    @Override
    public List<TMenu> getSelectAll() {
        return tMenuMapper.getSelectAll();
    }

    @Override
    public TMenu getSelectTMenuById(Integer id) {
        return tMenuMapper.getSelectTMenuById(id);
    }

    @Override
    public List<TMenu> getSelectTMenuByMenuName(String menu_name) {
        return tMenuMapper.getSelectTMenuByMenuName(menu_name);
    }

    @Override
    public int getUpdateTMenuAlterById(TMenu tMenu) {
        int i = tMenuMapper.getUpdateTMenuAlterById(tMenu);
        return i;
    }

    @Override
    public int getDeleteById(Integer id) {
        int i = tMenuMapper.getDeleteById(id);
        return i;
    }
}
