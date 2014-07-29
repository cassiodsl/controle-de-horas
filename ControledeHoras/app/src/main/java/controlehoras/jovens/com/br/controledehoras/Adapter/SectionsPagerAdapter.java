package controlehoras.jovens.com.br.controledehoras.Adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import java.util.Locale;

import controlehoras.jovens.com.br.controledehoras.fragment.CalendarFragment;
import controlehoras.jovens.com.br.controledehoras.fragment.HomeFragment;
import controlehoras.jovens.com.br.controledehoras.fragment.PlaceholderFragment;
import controlehoras.jovens.com.br.controledehoras.fragment.SaldoFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private final static int TAB_ABA_INICIO = 0;
    private final static int TAB_ABA_CALENDARIO = 1;
    private final static int TAB_ABA_SALDO = 2;

    protected static final String[] ABAS_DA_TABELA = new String[] {"Inicio" , "Saldo por dia" , "Saldo por quadrimestre"};

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /*
        Metodo responsavel por pegar a posicao clicada pelo usuario na tabela e direcionar
        para um fragment
      */

    @Override
    public Fragment getItem(int position) {
        if (position == TAB_ABA_INICIO) {
            return HomeFragment.newInstance(position + 1);
        } else if (position == TAB_ABA_CALENDARIO) {
            return CalendarFragment.newInstance(position + 1);
        } else if(position == TAB_ABA_SALDO) {
            return SaldoFragment.newInstance(position + 1);
        }
            return HomeFragment.newInstance(position + 1);
    }

    // Total de paginas na view
    @Override
    public int getCount() {
        return ABAS_DA_TABELA.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return ABAS_DA_TABELA[position];
    }
}