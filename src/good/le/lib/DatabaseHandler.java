package good.le.lib;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
	// Database Name
	private static final String DB_NAME = "goodle";

	// Database Version
	private static final int DB_VERSION = 1;

	// Table Name
	private static final String TBL_KANDIDAT = "kandidat";
	private static final String TBL_KANDIDAT_RPN = "kandidat_rpn";
	private static final String TBL_KANDIDAT_RPK = "kandidat_rpk";
	private static final String TBL_KANDIDAT_RO = "kandidat_ro";
	private static final String TBL_KANDIDAT_RPH = "kandidat_rph";
	private static final String TBL_EVENTS = "events";
	private static final String TBL_JANJI = "janji";
	private static final String TBL_KEUANGAN = "keuangan";

	// Global Column
	private static final String KEY_ID = "id";
	private static final String KEY_ID_KANDIDAT = "id_kandidat";
	private static final String KEY_RINGKASAN = "ringkasan";
	private static final String KEY_TANGGAL_MULAI = "tanggal_mulai";
	private static final String KEY_TANGGAL_SELESAI = "tanggal_selesai";
	private static final String KEY_JABATAN = "jabatan";
	private static final String KEY_TANGGAL = "tanggal";
	private static final String KEY_INSTITUSI = "institusi";

	// Column Table Kandidat
	private static final String KEY_INISIAL = "inisial";
	private static final String KEY_TAHUN = "tahun";
	private static final String KEY_ROLE = "role";
	private static final String KEY_RUNNING_MATE = "running_mate";
	private static final String KEY_JENIS_KELAMIN = "jenis_kelamin";
	private static final String KEY_AGAMA = "agama";
	private static final String KEY_TEMPAT_LAHIR = "tempat_lahir";
	private static final String KEY_TANGGAL_LAHIR = "tanggal_lahir";
	private static final String KEY_STATUS_KAWIN = "status_kawin";
	private static final String KEY_NAMA_PASANGAN = "nama_pasangan";
	private static final String KEY_JUMLAH_ANAK = "jumlah_anak";
	private static final String KEY_KELURAHAN_TINGGAL = "kelurahan_tinggal";
	private static final String KEY_KECAMATAN = "kecamatan";
	private static final String KEY_KOTA_TINGGAL = "kota_tinggal";
	private static final String KEY_PROVINSI = "provinsi";
	private static final String KEY_NAMA_PARTAI = "nama_partai";
	private static final String KEY_BIOGRAFI = "biografi";
	
	//Column for table Events
	private static final String KEY_INISIAL_KANDIDAT = "inisial_kandidat";
	private static final String KEY_JUDUL = "judul";
	private static final String KEY_DESKRIPSI = "deskripsi";
	private static final String KEY_WAKTU_MULAI = "waktu_mulai";
	private static final String KEY_TAGS = "tags";
	
	//Colum for table Janji
	private static final String KEY_CONTEXT_JANJI = "context_janji";
	private static final String KEY_JANJI = "janji";
	private static final String KEY_JUDUL_SUMBER = "judul_sumber";
	private static final String KEY_URL_SUMBER = "url_sumber";
	
	//Column for table Keuangan
	private static final String KEY_PERIODE = "periode";
	private static final String KEY_LEMBAGA = "lembaga";
	private static final String KEY_MATAUANG = "mata_uang";
	private static final String KEY_UANG = "uang";
	private static final String KEY_NILAIBARANG = "nilai_barang";
	private static final String KEY_UNITBARANG = "unit_barang";
	private static final String KEY_NILAIJASA = "nilai_jasa";
	private static final String KEY_BENTUKJASA = "bentuk_jasa";
	private static final String KEY_JUMLAH = "jumlah";
	private static final String KEY_KETERANGAN = "keterangan";

	public DatabaseHandler(Context _context) {
		super(_context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String CREATE_TABLE_KANDIDAT = "CREATE TABLE " + TBL_KANDIDAT + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_INISIAL + " TEXT,"
				+ KEY_TAHUN + " INTEGER," + KEY_ROLE + " TEXT,"
				+ KEY_RUNNING_MATE + " TEXT," + KEY_JENIS_KELAMIN + " TEXT,"
				+ KEY_AGAMA + " TEXT," + KEY_TEMPAT_LAHIR + " TEXT,"
				+ KEY_TANGGAL_LAHIR + " TEXT," + KEY_STATUS_KAWIN + " TEXT,"
				+ KEY_NAMA_PASANGAN + " TEXT," + KEY_JUMLAH_ANAK + " INTEGER,"
				+ KEY_KELURAHAN_TINGGAL + " TEXT," + KEY_KECAMATAN + " TEXT,"
				+ KEY_KOTA_TINGGAL + " TEXT," + KEY_PROVINSI + " TEXT,"
				+ KEY_NAMA_PARTAI + " TEXT," + KEY_BIOGRAFI + " TEXT" + ")";
		db.execSQL(CREATE_TABLE_KANDIDAT);

		String CREATE_TABLE_RPN = "CREATE TABLE " + TBL_KANDIDAT_RPN + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_ID_KANDIDAT
				+ " INTEGER," + KEY_RINGKASAN + " TEXT," + KEY_TANGGAL_MULAI
				+ " TEXT," + KEY_TANGGAL_SELESAI + " TEXT" + ")";
		db.execSQL(CREATE_TABLE_RPN);

		String CREATE_TABLE_RPK = "CREATE TABLE " + TBL_KANDIDAT_RPK + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_ID_KANDIDAT
				+ " INTEGER," + KEY_RINGKASAN + " TEXT," + KEY_TANGGAL_MULAI
				+ " TEXT," + KEY_TANGGAL_SELESAI + " TEXT" + ")";
		db.execSQL(CREATE_TABLE_RPK);

		String CREATE_TABLE_RO = "CREATE TABLE " + TBL_KANDIDAT_RO + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_ID_KANDIDAT
				+ " INTEGER," + KEY_RINGKASAN + " TEXT," + KEY_JABATAN
				+ " TEXT," + KEY_TANGGAL_MULAI + " TEXT," + KEY_TANGGAL_SELESAI
				+ " TEXT" + ")";
		db.execSQL(CREATE_TABLE_RO);

		String CREATE_TABLE_RPH = "CREATE TABLE " + TBL_KANDIDAT_RPH + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_RINGKASAN + " TEXT,"
				+ KEY_INSTITUSI + " TEXT," + KEY_TANGGAL + " TEXT" + ")";
		db.execSQL(CREATE_TABLE_RPH);
		
		String CREATE_TABLE_EVENTS = "CREATE TABLE " + TBL_EVENTS + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_INISIAL_KANDIDAT + " TEXT,"
				+ KEY_JUDUL + " TEXT," + KEY_DESKRIPSI + " TEXT," 
				+ KEY_TANGGAL_MULAI + " TEXT," + KEY_WAKTU_MULAI + " TEXT," 
				+ KEY_TANGGAL_SELESAI + " TEXT," + KEY_TAGS + " TEXT" + ")";
		db.execSQL(CREATE_TABLE_EVENTS);
		
		String CREATE_TABLE_JANJI = "CREATE TABLE " + TBL_EVENTS + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_INISIAL_KANDIDAT + " TEXT,"
				+ KEY_CONTEXT_JANJI + " TEXT," + KEY_JANJI + " TEXT," 
				+ KEY_TANGGAL + " TEXT," + KEY_JUDUL_SUMBER + " TEXT," 
				+ KEY_URL_SUMBER + " TEXT," + KEY_TAGS + " TEXT" + ")";
		db.execSQL(CREATE_TABLE_JANJI);
		
		String CREATE_TABLE_KEUANGAN = "CREATE TABLE " + TBL_KEUANGAN + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_PERIODE + " TEXT,"
				+ KEY_ROLE + " TEXT," + KEY_NAMA_PARTAI + " TEXT," 
				+ KEY_INISIAL_KANDIDAT + " TEXT," + KEY_LEMBAGA + " TEXT,"
				+ KEY_TAHUN + " INTEGER," + KEY_MATAUANG + " TEXT,"
				+ KEY_UANG + " INTEGER," + KEY_NILAIBARANG + " INTEGER,"
				+ KEY_UNITBARANG + " INTEGER," + KEY_NILAIJASA + " INTEGER,"
				+ KEY_BENTUKJASA + " TEXT," + KEY_JUMLAH + " INTEGER,"
				+ KEY_KETERANGAN + " TEXT" + ")";
		db.execSQL(CREATE_TABLE_KEUANGAN);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + TBL_KANDIDAT);
		db.execSQL("DROP TABLE IF EXISTS " + TBL_KANDIDAT_RPN);
		db.execSQL("DROP TABLE IF EXISTS " + TBL_KANDIDAT_RPK);
		db.execSQL("DROP TABLE IF EXISTS " + TBL_KANDIDAT_RO);
		db.execSQL("DROP TABLE IF EXISTS " + TBL_KANDIDAT_RPH);
		db.execSQL("DROP TABLE IF EXISTS " + TBL_EVENTS);
		db.execSQL("DROP TABLE IF EXISTS " + TBL_JANJI);

		onCreate(db);
	}

	public void addKandidat(KandidatClass kandidat) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(KEY_ID, kandidat.getID()); 
		cv.put(KEY_INISIAL, kandidat.getInisial());
		cv.put(KEY_TAHUN, kandidat.getTahun());
		cv.put(KEY_ROLE, kandidat.getRole());
		cv.put(KEY_RUNNING_MATE, kandidat.getRunningMate());
		cv.put(KEY_JENIS_KELAMIN, kandidat.getJenisKelamin());
		cv.put(KEY_AGAMA, kandidat.getAgama());
		cv.put(KEY_TEMPAT_LAHIR, kandidat.getTempatLahir());
		cv.put(KEY_TANGGAL_LAHIR, kandidat.getTanggalLahir());
		cv.put(KEY_STATUS_KAWIN, kandidat.getStatusKawin());
		cv.put(KEY_NAMA_PASANGAN, kandidat.getNamaPasangan());
		cv.put(KEY_JUMLAH_ANAK, kandidat.getJumlahAnak());
		cv.put(KEY_KELURAHAN_TINGGAL, kandidat.getKelurahan());
		cv.put(KEY_KECAMATAN, kandidat.getKecamatan());
		cv.put(KEY_KOTA_TINGGAL, kandidat.getKota());
		cv.put(KEY_PROVINSI, kandidat.getProvinsi());
		cv.put(KEY_NAMA_PARTAI, kandidat.getNamaPartai());
		cv.put(KEY_BIOGRAFI, kandidat.getBiografi());

		db.insert(TBL_KANDIDAT, null, cv);
		db.close();
	}

	public void addRiwayatRPN(RiwayatPPClass rpp) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(KEY_ID, rpp.getID());
		cv.put(KEY_ID_KANDIDAT, rpp.getIDKandidat());
		cv.put(KEY_RINGKASAN, rpp.getRingkasan());
		cv.put(KEY_TANGGAL_MULAI, rpp.getTahunMulai());
		cv.put(KEY_TANGGAL_SELESAI, rpp.getTahunSelesai());

		db.insert(TBL_KANDIDAT_RPN, null, cv);
		db.close();
	}
	
	public void addRiwayatRPK(RiwayatPPClass rpp) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(KEY_ID, rpp.getID());
		cv.put(KEY_ID_KANDIDAT, rpp.getIDKandidat());
		cv.put(KEY_RINGKASAN, rpp.getRingkasan());
		cv.put(KEY_TANGGAL_MULAI, rpp.getTahunMulai());
		cv.put(KEY_TANGGAL_SELESAI, rpp.getTahunSelesai());

		db.insert(TBL_KANDIDAT_RPK, null, cv);
		db.close();
	}
	
	public void addRiwayatRO(RiwayatROClass rro) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(KEY_ID, rro.getID());
		cv.put(KEY_ID_KANDIDAT, rro.getIDKandidat());
		cv.put(KEY_RINGKASAN, rro.getRingkasan());
		cv.put(KEY_JABATAN, rro.getJabatan());
		cv.put(KEY_TANGGAL_MULAI, rro.getTahunMulai());
		cv.put(KEY_TANGGAL_SELESAI, rro.getTahunSelesai());

		db.insert(TBL_KANDIDAT_RO, null, cv);
		db.close();
	}
	
	public void addRiwayatPH(RiwayatPHClass rph) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(KEY_ID, rph.getID());
		cv.put(KEY_ID_KANDIDAT, rph.getIDKandidat());
		cv.put(KEY_RINGKASAN, rph.getRingkasan());
		cv.put(KEY_INSTITUSI, rph.getInstitusi());
		cv.put(KEY_TANGGAL, rph.getTanggal());

		db.insert(TBL_KANDIDAT_RPH, null, cv);
		db.close();
	}
	
	public void addEvents(EventsClass events) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(KEY_ID, events.getID());
		cv.put(KEY_INISIAL_KANDIDAT, events.getInisialKandidat());
		cv.put(KEY_JUDUL, events.getJudul());
		cv.put(KEY_DESKRIPSI, events.getDeskripsi());
		cv.put(KEY_TANGGAL_MULAI, events.getTanggalMulai());
		cv.put(KEY_WAKTU_MULAI, events.getWaktuMulai());
		cv.put(KEY_TANGGAL_SELESAI, events.getTanggalSelesai());
		cv.put(KEY_TAGS, events.getTags());

		db.insert(TBL_EVENTS, null, cv);
		db.close();
	}
	
	public void addJanji(JanjiClass janji) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(KEY_ID, janji.getID());
		cv.put(KEY_INISIAL_KANDIDAT, janji.getInisialKandidat());
		cv.put(KEY_CONTEXT_JANJI, janji.getContextJanji());
		cv.put(KEY_JANJI, janji.getJanji());
		cv.put(KEY_TANGGAL, janji.getTanggal());
		cv.put(KEY_JUDUL_SUMBER, janji.getJudulSumber());
		cv.put(KEY_URL_SUMBER, janji.getUrlSumber());
		cv.put(KEY_TAGS, janji.getTagsJanji());

		db.insert(TBL_JANJI, null, cv);
		db.close();
	}
	
	public void addKeuangan(KeuanganClass uang) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(KEY_ID, uang.getID());
		cv.put(KEY_PERIODE, uang.getPeriode());
		cv.put(KEY_ROLE, uang.getRole());
		cv.put(KEY_NAMA_PARTAI, uang.getPartai());
		cv.put(KEY_INISIAL_KANDIDAT, uang.getIDCalon());
		cv.put(KEY_LEMBAGA, uang.getLembaga());
		cv.put(KEY_TAHUN, uang.getTahun());
		cv.put(KEY_MATAUANG, uang.getMataUang());
		cv.put(KEY_UANG, uang.getUang());
		cv.put(KEY_NILAIBARANG, uang.getNilaiBarang());
		cv.put(KEY_UNITBARANG, uang.getUnitBarang());
		cv.put(KEY_NILAIJASA, uang.getNilaiJasa());
		cv.put(KEY_BENTUKJASA, uang.getBentukJasa());
		cv.put(KEY_JUMLAH, uang.getJumlah());
		cv.put(KEY_KETERANGAN, uang.getKeterangan());

		db.insert(TBL_KEUANGAN, null,cv);
		db.close();
	}

	public void deleteKandidat(KandidatClass kandidat) {
		SQLiteDatabase db = getWritableDatabase();

		db.delete(TBL_KANDIDAT, KEY_ID + " = ? ",
				new String[] { String.valueOf(kandidat.getID()) });
		db.close();
	}
	
	public void deleteRiwayatRPN(RiwayatPPClass rpp) {
		SQLiteDatabase db = getWritableDatabase();

		db.delete(TBL_KANDIDAT_RPN, KEY_ID + " = ? ",
				new String[] { String.valueOf(rpp.getID()) });
		db.close();
	}
	
	public void deleteRiwayatRPK(RiwayatPPClass rpp) {
		SQLiteDatabase db = getWritableDatabase();

		db.delete(TBL_KANDIDAT_RPK, KEY_ID + " = ? ",
				new String[] { String.valueOf(rpp.getID()) });
		db.close();
	}
	
	public void deleteRiwayatRO(RiwayatROClass rro) {
		SQLiteDatabase db = getWritableDatabase();

		db.delete(TBL_KANDIDAT_RO, KEY_ID + " = ? ",
				new String[] { String.valueOf(rro.getID()) });
		db.close();
	}
	
	public void deleteRiwayatPH(RiwayatPHClass rph) {
		SQLiteDatabase db = getWritableDatabase();

		db.delete(TBL_KANDIDAT_RPH, KEY_ID + " = ? ",
				new String[] { String.valueOf(rph.getID()) });
		db.close();
	}
	
	public void deleteEvents(EventsClass events) {
		SQLiteDatabase db = getWritableDatabase();

		db.delete(TBL_EVENTS, KEY_ID + " = ? ",
				new String[] { String.valueOf(events.getID())});
		db.close();
	}
	
	public void deleteJanji(JanjiClass janji) {
		SQLiteDatabase db = getWritableDatabase();

		db.delete(TBL_JANJI, KEY_ID + " = ? ",
				new String[] { String.valueOf(janji.getID())});
		db.close();
	}
	
	public void deleteKeuangan(KeuanganClass uang) {
		SQLiteDatabase db = getWritableDatabase();

		db.delete(TBL_KEUANGAN, KEY_ID + " = ? ",
				new String[] { String.valueOf(uang.getID())});
		db.close();
	}

	public KandidatClass getKandidat(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TBL_KANDIDAT, new String[] { KEY_ID, KEY_INISIAL,
				KEY_TAHUN, KEY_ROLE, KEY_RUNNING_MATE, KEY_JENIS_KELAMIN, KEY_AGAMA, KEY_TEMPAT_LAHIR, KEY_TANGGAL_LAHIR, KEY_STATUS_KAWIN, KEY_NAMA_PASANGAN, KEY_JUMLAH_ANAK, KEY_KELURAHAN_TINGGAL, KEY_KECAMATAN, KEY_KOTA_TINGGAL, KEY_PROVINSI, KEY_NAMA_PARTAI, KEY_BIOGRAFI }, 
				"ID = ?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		return new KandidatClass(Integer.valueOf(cursor.getString(0)), Integer.valueOf(cursor.getString(1)), Integer.valueOf(cursor.getString(2)), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10), cursor.getString(11), cursor.getString(12), cursor.getString(13), cursor.getString(14), cursor.getString(15), cursor.getString(16), cursor.getString(17));
	}

	public RiwayatPPClass getRiwayatRPN(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TBL_KANDIDAT_RPN, new String[] { KEY_ID, KEY_ID_KANDIDAT,
				KEY_RINGKASAN, KEY_TANGGAL_MULAI, KEY_TANGGAL_SELESAI }, "ID = ?", new String[] { String.valueOf(id) },
				null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		return new RiwayatPPClass(Integer.valueOf(cursor.getString(0)), Integer.valueOf(cursor.getString(1)), cursor.getString(2), cursor.getString(3), cursor.getString(4));
	}
	
	public RiwayatPPClass getRiwayatRPK(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TBL_KANDIDAT_RPK, new String[] { KEY_ID, KEY_ID_KANDIDAT,
				KEY_RINGKASAN, KEY_TANGGAL_MULAI, KEY_TANGGAL_SELESAI }, "ID = ?", new String[] { String.valueOf(id) },
				null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		return new RiwayatPPClass(Integer.valueOf(cursor.getString(0)), Integer.valueOf(cursor.getString(1)), cursor.getString(2), cursor.getString(3), cursor.getString(4));
	}
	
	public RiwayatROClass getRiwayatRO(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TBL_KANDIDAT_RO, new String[] { KEY_ID, KEY_ID_KANDIDAT,
				KEY_RINGKASAN, KEY_JABATAN, KEY_TANGGAL_MULAI, KEY_TANGGAL_SELESAI }, "ID = ?", new String[] { String.valueOf(id) },
				null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		return new RiwayatROClass(Integer.valueOf(cursor.getString(0)), Integer.valueOf(cursor.getString(1)), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
	}
	
	public RiwayatPHClass getRiwayatPH(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TBL_KANDIDAT_RPH, new String[] { KEY_ID, KEY_ID_KANDIDAT,
				KEY_RINGKASAN, KEY_INSTITUSI, KEY_TANGGAL}, "ID = ?", new String[] { String.valueOf(id) },
				null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		return new RiwayatPHClass(Integer.valueOf(cursor.getString(0)), Integer.valueOf(cursor.getString(1)), cursor.getString(2), cursor.getString(3), cursor.getString(4));
	}
	
	public EventsClass getEvents(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TBL_EVENTS, new String[] { KEY_ID, KEY_INISIAL_KANDIDAT,
				KEY_JUDUL, KEY_DESKRIPSI, KEY_TANGGAL_MULAI, KEY_WAKTU_MULAI, KEY_TANGGAL_SELESAI, KEY_TAGS}, "ID = ?", new String[] { String.valueOf(id) },
				null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		return new EventsClass(Integer.valueOf(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7));
	}
	
	public JanjiClass getJanji(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TBL_JANJI, new String[] { KEY_ID, KEY_INISIAL_KANDIDAT,
				KEY_CONTEXT_JANJI, KEY_JANJI, KEY_TANGGAL, KEY_JUDUL_SUMBER, KEY_URL_SUMBER, KEY_TAGS}, "ID = ?", new String[] { String.valueOf(id) },
				null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		return new JanjiClass(Integer.valueOf(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7));
	}
	
	public KeuanganClass getKeuangan(int id) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(TBL_KEUANGAN, new String[] { KEY_ID, KEY_PERIODE, KEY_ROLE, KEY_NAMA_PARTAI, KEY_INISIAL_KANDIDAT, KEY_LEMBAGA,
		KEY_TAHUN,KEY_MATAUANG, KEY_UANG, KEY_NILAIBARANG, KEY_UNITBARANG, KEY_NILAIJASA,
		KEY_BENTUKJASA, KEY_JUMLAH,KEY_KETERANGAN}, "ID = ?", new String[] { String.valueOf(id) },
				null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		return new KeuanganClass(cursor.getInt(cursor.getColumnIndex(KEY_ID)), cursor.getInt(cursor.getColumnIndex(KEY_TAHUN)), cursor.getInt(cursor.getColumnIndex(KEY_UANG)), cursor.getInt(cursor.getColumnIndex(KEY_NILAIBARANG)), cursor.getInt(cursor.getColumnIndex(KEY_UNITBARANG)), cursor.getInt(cursor.getColumnIndex(KEY_NILAIJASA)), cursor.getInt(cursor.getColumnIndex(KEY_JUMLAH)), cursor.getString(cursor.getColumnIndex(KEY_PERIODE)), cursor.getString(cursor.getColumnIndex(KEY_ROLE)), cursor.getString(cursor.getColumnIndex(KEY_NAMA_PARTAI)), cursor.getString(cursor.getColumnIndex(KEY_INISIAL_KANDIDAT)), cursor.getString(cursor.getColumnIndex(KEY_LEMBAGA)), cursor.getString(cursor.getColumnIndex(KEY_MATAUANG)), cursor.getString(cursor.getColumnIndex(KEY_BENTUKJASA)), cursor.getString(cursor.getColumnIndex(KEY_KETERANGAN)));
	}

	/**public ArrayList<ProfileClass> getSemuaProfile() {
		ArrayList<ProfileClass> profileList = new ArrayList<ProfileClass>();

		String selectQuery = "SELECT * FROM " + TBL_PROFILE;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		if (cursor.moveToFirst())
			do {
				ProfileClass profile = new ProfileClass();
				profile.setID(Integer.parseInt(cursor.getString(cursor
						.getColumnIndex(KEY_ID))));
				profile.setProfile(cursor.getString(cursor
						.getColumnIndex(KEY_PROFILE)));
				profile.setUname(cursor.getString(cursor
						.getColumnIndex(KEY_UNAME)));

				profileList.add(profile);
			} while (cursor.moveToNext());

		return profileList;
	}**/
	
	public void updateKandidat(KandidatClass kandidat) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(KEY_ID, kandidat.getID()); 
		cv.put(KEY_INISIAL, kandidat.getInisial());
		cv.put(KEY_TAHUN, kandidat.getTahun());
		cv.put(KEY_ROLE, kandidat.getRole());
		cv.put(KEY_RUNNING_MATE, kandidat.getRunningMate());
		cv.put(KEY_JENIS_KELAMIN, kandidat.getJenisKelamin());
		cv.put(KEY_AGAMA, kandidat.getAgama());
		cv.put(KEY_TEMPAT_LAHIR, kandidat.getTempatLahir());
		cv.put(KEY_TANGGAL_LAHIR, kandidat.getTanggalLahir());
		cv.put(KEY_STATUS_KAWIN, kandidat.getStatusKawin());
		cv.put(KEY_NAMA_PASANGAN, kandidat.getNamaPasangan());
		cv.put(KEY_JUMLAH_ANAK, kandidat.getJumlahAnak());
		cv.put(KEY_KELURAHAN_TINGGAL, kandidat.getKelurahan());
		cv.put(KEY_KECAMATAN, kandidat.getKecamatan());
		cv.put(KEY_KOTA_TINGGAL, kandidat.getKota());
		cv.put(KEY_PROVINSI, kandidat.getProvinsi());
		cv.put(KEY_NAMA_PARTAI, kandidat.getNamaPartai());
		cv.put(KEY_BIOGRAFI, kandidat.getBiografi());

		db.update(TBL_KANDIDAT, cv, "ID = ?",
				new String[] { String.valueOf(kandidat.getID()) });
		db.close();
	}

	public void updateRiwayatRPN(RiwayatPPClass rpp) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(KEY_ID, rpp.getID());
		cv.put(KEY_ID_KANDIDAT, rpp.getIDKandidat());
		cv.put(KEY_RINGKASAN, rpp.getRingkasan());
		cv.put(KEY_TANGGAL_MULAI, rpp.getTahunMulai());
		cv.put(KEY_TANGGAL_SELESAI, rpp.getTahunSelesai());

		db.update(TBL_KANDIDAT_RPN, cv, "ID = ?",
				new String[] { String.valueOf(rpp.getID()) });
		db.close();
	}
	
	public void updateRiwayatRK(RiwayatPPClass rpp) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(KEY_ID, rpp.getID());
		cv.put(KEY_ID_KANDIDAT, rpp.getIDKandidat());
		cv.put(KEY_RINGKASAN, rpp.getRingkasan());
		cv.put(KEY_TANGGAL_MULAI, rpp.getTahunMulai());
		cv.put(KEY_TANGGAL_SELESAI, rpp.getTahunSelesai());

		db.update(TBL_KANDIDAT_RPK, cv, "ID = ?",
				new String[] { String.valueOf(rpp.getID()) });
		db.close();
	}
	
	public void updateRiwayatRO(RiwayatROClass rro) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(KEY_ID, rro.getID());
		cv.put(KEY_ID_KANDIDAT, rro.getIDKandidat());
		cv.put(KEY_RINGKASAN, rro.getRingkasan());
		cv.put(KEY_JABATAN, rro.getJabatan());
		cv.put(KEY_TANGGAL_MULAI, rro.getTahunMulai());
		cv.put(KEY_TANGGAL_SELESAI, rro.getTahunSelesai());

		db.update(TBL_KANDIDAT_RO, cv, "ID = ?",
				new String[] { String.valueOf(rro.getID()) });
		db.close();
	}
	
	public void updateRiwayatPH(RiwayatPHClass rph) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(KEY_ID, rph.getID());
		cv.put(KEY_ID_KANDIDAT, rph.getIDKandidat());
		cv.put(KEY_RINGKASAN, rph.getRingkasan());
		cv.put(KEY_INSTITUSI, rph.getInstitusi());
		cv.put(KEY_TANGGAL, rph.getTanggal());

		db.update(TBL_KANDIDAT_RPH, cv, "ID = ?",
				new String[] { String.valueOf(rph.getID()) });
		db.close();
	}
	
	public void updateEvents(EventsClass events) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(KEY_ID, events.getID());
		cv.put(KEY_INISIAL_KANDIDAT, events.getInisialKandidat());
		cv.put(KEY_JUDUL, events.getJudul());
		cv.put(KEY_DESKRIPSI, events.getDeskripsi());
		cv.put(KEY_TANGGAL_MULAI, events.getTanggalMulai());
		cv.put(KEY_WAKTU_MULAI, events.getWaktuMulai());
		cv.put(KEY_TANGGAL_SELESAI, events.getTanggalSelesai());
		cv.put(KEY_TAGS, events.getTags());

		db.update(TBL_EVENTS, cv, "ID = ?",
				new String[] { String.valueOf(events.getID()) });
		db.close();
	}
	
	public void updateJanji(JanjiClass janji) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(KEY_ID, janji.getID());
		cv.put(KEY_INISIAL_KANDIDAT, janji.getInisialKandidat());
		cv.put(KEY_CONTEXT_JANJI, janji.getContextJanji());
		cv.put(KEY_JANJI, janji.getJanji());
		cv.put(KEY_TANGGAL, janji.getTanggal());
		cv.put(KEY_JUDUL_SUMBER, janji.getJudulSumber());
		cv.put(KEY_URL_SUMBER, janji.getUrlSumber());
		cv.put(KEY_TAGS, janji.getTagsJanji());

		db.update(TBL_JANJI, cv, "ID = ?",
				new String[] { String.valueOf(janji.getID()) });
		db.close();
	}
	
	public void updateKeuangan(KeuanganClass uang) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(KEY_ID, uang.getID());
		cv.put(KEY_PERIODE, uang.getPeriode());
		cv.put(KEY_ROLE, uang.getRole());
		cv.put(KEY_NAMA_PARTAI, uang.getPartai());
		cv.put(KEY_INISIAL_KANDIDAT, uang.getIDCalon());
		cv.put(KEY_LEMBAGA, uang.getLembaga());
		cv.put(KEY_TAHUN, uang.getTahun());
		cv.put(KEY_MATAUANG, uang.getMataUang());
		cv.put(KEY_UANG, uang.getUang());
		cv.put(KEY_NILAIBARANG, uang.getNilaiBarang());
		cv.put(KEY_UNITBARANG, uang.getUnitBarang());
		cv.put(KEY_NILAIJASA, uang.getNilaiJasa());
		cv.put(KEY_BENTUKJASA, uang.getBentukJasa());
		cv.put(KEY_JUMLAH, uang.getJumlah());
		cv.put(KEY_KETERANGAN, uang.getKeterangan());

		db.update(TBL_KEUANGAN, cv, "ID = ?",
				new String[] { String.valueOf(uang.getID()) });
		db.close();
	}

	/**public boolean parkirExists(Integer _id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TBL_ITEM, new String[] { KEY_ID }, "ID = ?",
				new String[] { String.valueOf(_id) }, null, null, null, null);
		boolean exists = (cursor.getCount() > 0);
		cursor.close();
		return exists;
	}

	public boolean profileExists(Integer _id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TBL_PROFILE, new String[] { KEY_ID },
				"ID = ?", new String[] { String.valueOf(_id) }, null, null,
				null, null);
		boolean exists = (cursor.getCount() > 0);
		cursor.close();
		return exists;
	}**/
}
