package com.adit.calvolume.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.adit.calvolume.R;
import com.adit.calvolume.util.BalokIndex;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BalokFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class BalokFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public BalokFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_balok, container, false);
        final EditText panjang  = view.findViewById(R.id.edt_length);
        final EditText lebar  = view.findViewById(R.id.edt_width);
        final EditText tinggi  = view.findViewById(R.id.edt_height);

        Button calculateButton = view.findViewById(R.id.btn_calculate);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    String heightString = tinggi.getText().toString();
                    String weightString = lebar.getText().toString();
                    String lengthString= panjang.getText().toString();

                    int height = Integer.parseInt(heightString);
                    int weight = Integer.parseInt(weightString);
                    int length = Integer.parseInt(lengthString);
                    BalokIndex balokIndex= new BalokIndex(height, weight, length);
                    mListener.onBalokButtonClicked(balokIndex.getIndex(),balokIndex.calculate());
                }
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {

        void onBalokButtonClicked(float index, float calculate);
    }
}
