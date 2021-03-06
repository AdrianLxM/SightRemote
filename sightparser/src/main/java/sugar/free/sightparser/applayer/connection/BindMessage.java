package sugar.free.sightparser.applayer.connection;

import org.spongycastle.util.encoders.Hex;

import lombok.Getter;
import sugar.free.sightparser.applayer.AppLayerMessage;
import sugar.free.sightparser.applayer.Service;
import sugar.free.sightparser.error.SightError;
import sugar.free.sightparser.error.UnknownAppErrorCodeError;
import sugar.free.sightparser.pipeline.ByteBuf;

public class BindMessage extends AppLayerMessage {

    @Getter
    private byte[] modelNumber;

    @Override
    public Service getService() {
        return Service.CONNECTION;
    }

    @Override
    public short getCommand() {
        return (short) 0xCDF3;
    }

    @Override
    protected byte[] getData() {
        return Hex.decode("3438310000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    }

    @Override
    protected void parse(ByteBuf byteBuf) throws Exception {
        modelNumber = byteBuf.readBytesLE(16);
    }
}
