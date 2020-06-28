package Adaptadores;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pt.ipg.drivecure.R;

public class adaptadorFun extends RecyclerView.Adapter<adaptadorFun.MyViewHolder> {

    private Context context;
    private ArrayList id_funcionario, nomeFuncionario, emailFuncionario, numeroFuncionario;

    adaptadorFun(Context context, ArrayList id_funcionario, ArrayList nomeFuncionario, ArrayList emailFuncionario,
                  ArrayList numeroFuncionario){

        this.context = context;
        this.id_funcionario = id_funcionario;
        this.nomeFuncionario = nomeFuncionario;
        this.emailFuncionario = emailFuncionario;
        this.numeroFuncionario = numeroFuncionario;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dados_funcionarios, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView idFuncionario, nomeFuncionario, emailFuncionario, numerolFuncionario;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            idFuncionario = itemView.findViewById(R.id.funcionarioId);
            nomeFuncionario = itemView.findViewById(R.id.nomeFuncionario);
            emailFuncionario = itemView.findViewById(R.id.emailFuncionario);
            numerolFuncionario = itemView.findViewById(R.id.numeroFuncionario);
        }
    }
}
