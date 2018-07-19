package com.kode.kreasi.kodekreasirecruitment.Adapter;

//public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder> {
//
//    private ArrayList<Notice> dataList;
//
//    public NoticeAdapter(ArrayList<Notice> dataList) {
//        this.dataList = dataList;
//    }
//
//    @NonNull
//    @Override
//    public NoticeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        View view = layoutInflater.inflate(R.layout.content_show_provinci, parent, false);
//        return new NoticeViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull NoticeViewHolder holder, int position) {
//        holder.tvTitle.setText(dataList.get(position).getTitle());
//        holder.tvBrief.setText(dataList.get(position).getBrief());
//        holder.tvFilePath.setText(dataList.get(position).getFilesource());
//    }
//
//    @Override
//    public int getItemCount() {
//        return dataList.size();
//    }
//
//    public class NoticeViewHolder extends RecyclerView.ViewHolder {
//        TextView tvTitle,tvBrief,tvFilePath;
//
//        public NoticeViewHolder(View itemView) {
//            super(itemView);
//            tvTitle = itemView.findViewById(R.id.tv_provinsi_title);
//            tvBrief = itemView.findViewById(R.id.tv_provinsi_brief);
//            tvFilePath = itemView.findViewById(R.id.tv_provinsi_file_path);
//        }
//    }
//}
