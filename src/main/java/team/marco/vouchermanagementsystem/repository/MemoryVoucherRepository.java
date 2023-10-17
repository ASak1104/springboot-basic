package team.marco.vouchermanagementsystem.repository;

import org.springframework.stereotype.Repository;
import team.marco.vouchermanagementsystem.model.Voucher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class MemoryVoucherRepository implements VoucherRepository {
    Map<UUID, Voucher> voucherMap = new HashMap<>();

    @Override
    public void save(Voucher voucher) {
        voucherMap.put(voucher.getId(), voucher);
    }

    @Override
    public List<Voucher> findAll() {
        return voucherMap.values().stream().toList();
    }
}