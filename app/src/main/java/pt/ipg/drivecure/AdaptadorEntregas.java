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

public class AdaptadorEntregas extends RecyclerView.Adapter<AdaptadorEntregas.MyViewHolder> {

    private Context context;
    Activity activity;
    private ArrayList id_cliente, nome_cliente, email_cliente, contacto_cliente;



    AdaptadorEntregas(Activity activity, Context context, ArrayList id_cliente, ArrayList nome_cliente, ArrayList email_cliente,
                          ArrayList contacto_cliente){

        this.activity = activity;
        this.context = context;
        this.id_cliente = id_cliente;
        this.nome_cliente = nome_cliente;
        this.email_cliente = email_cliente;
        this.contacto_cliente = contacto_cliente;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_entregas, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.id_cliente_txt.setText(String.valueOf(id_cliente.get(position)));
        holder.nome_cliente_txt.setText(String.valueOf(nome_cliente.get(position)));
        holder.email_cliente_txt.setText(String.valueOf(email_cliente.get(position)));
        holder.contacto_cliente_txt.setText(String.valueOf(contacto_cliente.get(position)));
        holder.mainLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { /* para conseguir dar trigger nos items do recycler view*/
                Intent intent = new Intent(context, updateFuncionarios.class);
                intent.putExtra("id", String.valueOf(id_cliente.get(position))); /* informaçoes que vao ser transeferidas para a update activity*/
                intent.putExtra("nome", String.valueOf(nome_cliente.get(position)));
                intent.putExtra("email", String.valueOf(email_cliente.get(position)));
                intent.putExtra("contacto", String.valueOf(contacto_cliente.get(position)));
                activity.startActivityForResult(intent, 1); // dá refresh à activity
            }
        });
    }

    @Override
    public int getItemCount() {
        return id_cliente.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id_cliente_txt, nome_cliente_txt, email_cliente_txt, contacto_cliente_txt;
        LinearLayout mainLayout2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            id_cliente_txt = itemView.findViewById(R.id.id_cliente_txt);
            nome_cliente_txt = itemView.findViewById(R.id.nome_cliente_txt);
            email_cliente_txt = itemView.findViewById(R.id.email_cliente_txt);
            contacto_cliente_txt = itemView.findViewById(R.id.contacto_cliente_txt);
            mainLayout2 = itemView.findViewById(R.id.mainLayout2);

        }
    }
}
