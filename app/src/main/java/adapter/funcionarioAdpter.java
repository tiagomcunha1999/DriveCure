package adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class funcionarioAdpter extends RecyclerView.Adapter <funcionarioAdpter.FuncionariosViewHolder> {

    private Context mContext;
    private Cursor mCursor;

    public funcionarioAdpter(Context context, Cursor cursor){
        mCursor = cursor;
        mContext = context;

    }

    public class FuncionariosViewHolder extends RecyclerView.ViewHolder{

        public TextView nomeFuncionario;
        public TextView emailFuncionario;
        public TextView numeroFuncionario;

        public FuncionariosViewHolder(@NonNull View itemView) {
            super(itemView);

            /*nomeFuncionario = itemView.findViewById(R.id.nomeFuncionario);
            emailFuncionario = itemView.findViewById(R.id.emailFuncionario);
            numeroFuncionario = itemView.findViewById(R.id.numeroFuncionario);*/


        }
    }

    @NonNull
    @Override
    public FuncionariosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FuncionariosViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
