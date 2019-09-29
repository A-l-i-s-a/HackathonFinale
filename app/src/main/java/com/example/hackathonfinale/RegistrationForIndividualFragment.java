package com.example.hackathonfinale;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.hackathonfinale.database.UserService;
import com.example.hackathonfinale.entities.User;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegistrationForIndividualFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RegistrationForIndividualFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistrationForIndividualFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public RegistrationForIndividualFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegistrationForIndividualFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistrationForIndividualFragment newInstance(String param1, String param2) {
        RegistrationForIndividualFragment fragment = new RegistrationForIndividualFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registration_for_individual, container, false);

        Button registrationButton = view.findViewById(R.id.buttonRegistration);


        EditText editTextFirstName = view.findViewById(R.id.editTextFirstName) ;
        EditText editTextSecondName = view.findViewById(R.id.editTextSecondName) ;
        EditText editTextLastName = view.findViewById(R.id.editTextLastName) ;
        final EditText editTextPhone = view.findViewById(R.id.editTextPhone) ;
        final EditText editTextPassword = view.findViewById(R.id.editTextPassword);

        final String name = editTextFirstName.getText().toString() + " " + editTextSecondName.getText().toString() + " " + editTextLastName.getText().toString();

        if (registrationButton != null) {
            registrationButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), ProblemsIndividualActivity.class);
                    User user = new User(name, editTextPhone.getText().toString(), editTextPassword.getText().toString(), "individual");
                    UserService userService = new UserService(getContext());
                    userService.addEntity(user);
                    startActivity(intent);
                }
            });
        }

        return view;
    }

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
