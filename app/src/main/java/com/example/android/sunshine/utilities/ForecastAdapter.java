package com.example.android.sunshine.utilities;

/**
 * Created by vinay goyal on 26-06-17.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.sunshine.R;

public class  ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {
    private String[] mWeatherData;
    public ForecastAdapter() {

    }

    public class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {
        public final TextView mWeatherTextView;
        public ForecastAdapterViewHolder(View value) {
            super(value);
            mWeatherTextView = (TextView) value.findViewById(R.id.tv_weather_data);
        }
    }
    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int listItemLayoutId = R.layout.forecast_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean attachingToParent = false;

        View value = inflater.inflate(listItemLayoutId, viewGroup, attachingToParent);
        return new ForecastAdapterViewHolder(value);
    }
    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder forecastAdapterViewHolder, int positionOfWeather) {
        String thisDayWeather = mWeatherData[positionOfWeather];
        forecastAdapterViewHolder.mWeatherTextView.setText(thisDayWeather);
    }
    @Override
    public int getItemCount() {
        if (null == mWeatherData) return 0;
        return mWeatherData.length;
    }
    public void setWeatherData(String[] weatherData) {
        mWeatherData = weatherData;
        notifyDataSetChanged();
    }
}