package org.hfoss.posit.android.api.plugin.commodity;

import java.util.List;

import org.hfoss.posit.android.R;
import org.hfoss.posit.android.api.Find;
import org.hfoss.posit.android.api.activity.ListFindsActivity;
import org.hfoss.posit.android.api.plugin.FindPluginManager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

public class CommodityListFindsActivity extends ListFindsActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	/**
	 * Sets up a custom list adapter specific to Commodity finds.
	 */
	@Override
	protected ListAdapter setUpAdapter() {

		List<? extends Find> list = this.getHelper().getAllFinds();

		int resId = getResources().getIdentifier(FindPluginManager.mFindPlugin.mListFindLayout,
			    "layout", getPackageName());
		
		CommodityFindsListAdapter adapter = new CommodityFindsListAdapter(this,
				resId, list);

		return adapter;
	}

	/**
	 * Adapter for displaying finds, extends FindsListAdapter to 
	 * take care of displaying the extra fields in CommodityFind.
	 * 
	 */
	private class CommodityFindsListAdapter extends FindsListAdapter{

		public CommodityFindsListAdapter(Context context, int textViewResourceId,
				List list) {
			super(context, textViewResourceId, list);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View v = convertView;
			if (v == null) {
				LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = vi.inflate(R.layout.outsidein_list_row, null);
			}
			CommodityFind find = (CommodityFind)items.get(position);
			if (find != null) {
				TextView tv = (TextView) v.findViewById(R.id.guid);
				tv.setText(find.getGuid());
				tv = (TextView) v.findViewById(R.id.latitude);
				tv.setText(String.valueOf(find.getLatitude()));
				tv = (TextView) v.findViewById(R.id.longitude);
				tv.setText(String.valueOf(find.getLongitude()));
//				tv = (TextView) v.findViewById(R.id.syringes_in);
//				tv.setText(String.valueOf(find.getSyringesIn()));
				tv = (TextView) v.findViewById(R.id.longitude);
//				tv.setText(String.valueOf(find.getSyringesOut()));
				tv = (TextView) v.findViewById(R.id.id);
				tv.setText(Integer.toString(find.getId()));

			}
			return v;
		}
	}

}
