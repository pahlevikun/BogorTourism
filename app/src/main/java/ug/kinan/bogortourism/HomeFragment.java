package ug.kinan.bogortourism;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;

/**
 * Created by farhan on 6/22/17.
 */

public class HomeFragment extends Fragment {

    private SliderLayout sliderShow;
    private CardView cvKuliner, cvSejarah, cvAlam, cvBogor, cvTentang, cvPertanyaan;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        //((MainActivity) getActivity()).setTitle("Beranda");

        sliderShow = (SliderLayout) view.findViewById(R.id.slider);
        cvKuliner = (CardView) view.findViewById(R.id.cardViewWisataKuliner);
        cvSejarah = (CardView) view.findViewById(R.id.cardViewWisataSejarah);
        cvAlam = (CardView) view.findViewById(R.id.cardViewWisataAlam);
        cvBogor = (CardView) view.findViewById(R.id.cardViewSejarahBogor);
        cvTentang = (CardView) view.findViewById(R.id.cardViewTentang);
        cvPertanyaan = (CardView) view.findViewById(R.id.cardViewFAQ);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Kota Bogor",R.drawable.bg_1);
        file_maps.put("Wisata Kuliner",R.drawable.bg_2);
        file_maps.put("Wisata Alam",R.drawable.bg_3);
        for(String name : file_maps.keySet()){
            DefaultSliderView defaultSliderView = new DefaultSliderView(getActivity());
            defaultSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            sliderShow.addSlider(defaultSliderView);
        }
        sliderShow.setPresetTransformer(SliderLayout.Transformer.Default);
        sliderShow.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderShow.setCustomAnimation(new DescriptionAnimation());
        sliderShow.setDuration(5000);

        cvTentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AboutActivity.class);
                startActivity(intent);
            }
        });

        cvPertanyaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FAQActivity.class);
                startActivity(intent);
            }
        });

        cvBogor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HistoryActivity.class);
                startActivity(intent);
            }
        });

        cvKuliner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WisataKulinerActivity.class);
                startActivity(intent);
            }
        });

        cvAlam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WisataAlamActivity.class);
                startActivity(intent);
            }
        });

        cvSejarah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WisataSejarahActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
