import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.countries.Country
import com.example.countries.R
import java.text.NumberFormat
import java.util.Locale

class CountriesAdapter(
    private var items: List<Country>
) : RecyclerView.Adapter<CountriesAdapter.VH>() {

    private val nf = NumberFormat.getInstance(Locale.getDefault())

    fun update(newItems: List<Country>) {
        items = newItems
        notifyDataSetChanged()
    }

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgFlag: ImageView = itemView.findViewById(R.id.imgFlag)
        val txtName: TextView = itemView.findViewById(R.id.txtName)
        val txtInfo: TextView = itemView.findViewById(R.id.txtInfo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_country, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val c = items[position]

        holder.txtName.text = c.name.common ?: "Unknown"

        val capital = c.capital?.firstOrNull() ?: "—"
        val region = c.region ?: "—"
        val population = c.population?.let { nf.format(it) } ?: "—"

        holder.txtInfo.text = "Capital: $capital  •  Region: $region  •  Populacion: $population"

        Glide.with(holder.itemView.context)
            .load(c.flags.png)
            .centerCrop()
            .into(holder.imgFlag)
    }

    override fun getItemCount(): Int = items.size
}
