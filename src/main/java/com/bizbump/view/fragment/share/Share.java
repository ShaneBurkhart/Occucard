package com.bizbump.view.fragment.share;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bizbump.R;
import com.bizbump.controller.MainActivity;
import com.bizbump.controller.share.ShareByEmailActivity;
import com.bizbump.controller.share.ShareByQRActivity;
import com.bizbump.utils.FontUtils;

/**
 * Created by Shane on 8/12/13.
 */
public class Share extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout v =  (LinearLayout) inflater.inflate(R.layout.share_options, container, false);

        v.findViewById(R.id.share_by_email).setOnClickListener(new ShareItemClickListener());
        v.findViewById(R.id.share_by_qr_code).setOnClickListener(new ShareItemClickListener());
        v.findViewById(R.id.share_by_bluetooth).setOnClickListener(new ShareItemClickListener());

        Typeface font = FontUtils.getIconFont(getActivity());
        ((TextView) v.findViewById(R.id.email_icon)).setTypeface(font);
        ((TextView) v.findViewById(R.id.blutooth_icon)).setTypeface(font);
        ((TextView) v.findViewById(R.id.qr_icon)).setTypeface(font);

        MainActivity activity = (MainActivity) getActivity();
        activity.actionBarState = MainActivity.NONE;
        activity.supportInvalidateOptionsMenu();

        activity.setTitle("Share");

        return v;
    }

    private class ShareItemClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent i = new Intent(getActivity(), getShareOptionActivityClass(view));
            getActivity().startActivity(i);
        }

        private Class getShareOptionActivityClass(View view){
            switch (view.getId()){
                case R.id.share_by_email:
                    return ShareByEmailActivity.class;
                case R.id.share_by_qr_code:
                    return ShareByQRActivity.class;
                case R.id.share_by_bluetooth:
                    return ShareByEmailActivity.class;
                default:
                    return ShareByEmailActivity.class;
            }
        }
    }
}