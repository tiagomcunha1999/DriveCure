package pt.ipg.drivecure;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adaptadorFuncionarios extends RecyclerView.Adapter<adaptadorFuncionarios.MyViewHolder> {

    private Context context;
    private ArrayList id_funcionario, nome_funcionario, email_funcionario, contacto_funcionario;


    CustomAdapter(Context context, ArrayList id_funcionario, ArrayList nome_funcionario, ArrayList email_funcionario,
                  ArrayList contacto_funcionairo){


        this.context = context;
        this.id_funcionario = id_funcionario;
        this.nome_funcionario = nome_funcionario;
        this.email_funcionario = email_funcionario;
        this.contacto_funcionario = contacto_funcionairo;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.row_funcionarios, parent, false);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
