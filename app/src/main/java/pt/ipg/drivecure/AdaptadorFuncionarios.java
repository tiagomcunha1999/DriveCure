package pt.ipg.drivecure;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorFuncionarios extends RecyclerView.Adapter<AdaptadorFuncionarios.MyViewHolder> {

    private Context context;
    Activity activity;
    private ArrayList id_funcionario, nome_funcionario, email_funcionario, contacto_funcionario;



    AdaptadorFuncionarios(Activity activity, Context context, ArrayList id_funcionario, ArrayList nome_funcionario, ArrayList email_funcionario,
                  ArrayList contacto_funcionairo){

        this.activity = activity;
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
        View view = inflater.inflate(R.layout.row_funcionarios, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.id_funcionario_txt.setText(String.valueOf(id_funcionario.get(position)));
        holder.nome_funcionario_txt.setText(String.valueOf(nome_funcionario.get(position)));
        holder.email_funcionario_txt.setText(String.valueOf(email_funcionario.get(position)));
        holder.contacto_funcionario_txt.setText(String.valueOf(contacto_funcionario.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { /* para conseguir dar trigger nos items do recycler view*/
            Intent intent = new Intent(context, updateFuncionarios.class);
            intent.putExtra("id", String.valueOf(id_funcionario.get(position))); /* informaçoes que vao ser transeferidas para a update activity*/
            intent.putExtra("nome", String.valueOf(nome_funcionario.get(position)));
            intent.putExtra("email", String.valueOf(email_funcionario.get(position)));
            intent.putExtra("contacto", String.valueOf(contacto_funcionario.get(position)));
            activity.startActivityForResult(intent, 1); // dá refresh à activity
            }
        });
    }

    @Override
    public int getItemCount() {
        return id_funcionario.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id_funcionario_txt, nome_funcionario_txt, email_funcionario_txt, contacto_funcionario_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            id_funcionario_txt = itemView.findViewById(R.id.id_funcionario_txt);
            nome_funcionario_txt = itemView.findViewById(R.id.nome_funcionario_txt);
            email_funcionario_txt = itemView.findViewById(R.id.email_funcionario_txt);
            contacto_funcionario_txt = itemView.findViewById(R.id.contacto_funcionario_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }
}
