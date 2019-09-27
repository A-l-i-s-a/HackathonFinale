package com.example.hackathonfinale;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegistrationMainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RegistrationMainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistrationMainFragment extends Fragment {

    RegistrationForEntityFragment registrationForEntityFragment;
    RegistrationForIndividualFragment registrationForIndividualFragment;
    FragmentTransaction fTrans;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public RegistrationMainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegistrationMainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistrationMainFragment newInstance(String param1, String param2) {
        RegistrationMainFragment fragment = new RegistrationMainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static RegistrationMainFragment newInstance() {
        RegistrationMainFragment fragment = new RegistrationMainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration_main, container, false);

        registrationForEntityFragment = new RegistrationForEntityFragment();
        registrationForIndividualFragment = new RegistrationForIndividualFragment();
        RadioButton radioButtonEntity = view.findViewById(R.id.radioButtonEntity);
        radioButtonEntity.setOnClickListener(radioButtonClickListener);
        RadioButton radioButtonIndividual = view.findViewById(R.id.radioButtonIndividual);
        radioButtonIndividual.setOnClickListener(radioButtonClickListener);
        return view;
    }

    private View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            fTrans = getFragmentManager().beginTransaction();
            RadioButton rb = (RadioButton) v;
            switch (rb.getId()) {
                case R.id.radioButtonEntity:
                    fTrans.replace(R.id.frgmCont, registrationForEntityFragment);
                    break;
                case R.id.radioButtonIndividual:
                    fTrans.replace(R.id.frgmCont, registrationForIndividualFragment);
                    break;
                default:
                    break;
            }
            fTrans.commit();
        }
    };

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
